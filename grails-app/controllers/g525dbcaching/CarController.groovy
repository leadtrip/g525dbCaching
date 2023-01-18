package g525dbcaching

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CarController {

    CarService carService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def testCaching() {
        log.info("================= Getting car with data service =================")
        def merc = carService.get(1)
        [dataServiceResult: merc,
         getCarResult: carService.getCar(1),
         readCarResult: carService.readCar(1),
         dynamicFinderResult: carService.findByEngine(merc.engine),
         criteriaResult: carService.findCarByName(merc.name),
        criteriaListResult: carService.findCarsByEngineBhpAndName( merc.name, merc.engine.bhp )]
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [cars: carService.list(params)]
    }

    def show(Long id) {
        respond carService.get(id)
    }

    def create() {
        respond new Car(params)
    }

    def save(Car car) {
        if (car == null) {
            notFound()
            return
        }

        try {
            carService.save(car)
        } catch (ValidationException e) {
            respond car.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'car.label', default: 'Car'), car.id])
                redirect car
            }
            '*' { respond car, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carService.get(id)
    }

    def update(Car car) {
        if (car == null) {
            notFound()
            return
        }

        try {
            carService.save(car)
        } catch (ValidationException e) {
            respond car.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'car.label', default: 'Car'), car.id])
                redirect car
            }
            '*'{ respond car, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'car.label', default: 'Car'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'car.label', default: 'Car'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
