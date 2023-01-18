package g525dbcaching

import grails.gorm.services.Service

@Service(Car)
abstract class CarService implements ICarService{

    def findByEngine( Engine engine ) {
        log.info("================= Getting car with dynamic finder =================")
        Car.findByEngine( engine )
    }

    def findCarByName( String name ) {
        log.info("================= Getting car with criteria query =================")
        Car.withCriteria {
            eq('name', name)
            cache true
        }[0]
    }

}