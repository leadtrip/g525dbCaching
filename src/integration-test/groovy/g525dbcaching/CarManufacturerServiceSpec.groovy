package g525dbcaching

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CarManufacturerServiceSpec extends Specification {

    ICarManufacturerService carManufacturerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CarManufacturer(...).save(flush: true, failOnError: true)
        //new CarManufacturer(...).save(flush: true, failOnError: true)
        //CarManufacturer carManufacturer = new CarManufacturer(...).save(flush: true, failOnError: true)
        //new CarManufacturer(...).save(flush: true, failOnError: true)
        //new CarManufacturer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //carManufacturer.id
    }

    void "test get"() {
        setupData()

        expect:
        carManufacturerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CarManufacturer> carManufacturerList = carManufacturerService.list(max: 2, offset: 2)

        then:
        carManufacturerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        carManufacturerService.count() == 5
    }

    void "test delete"() {
        Long carManufacturerId = setupData()

        expect:
        carManufacturerService.count() == 5

        when:
        carManufacturerService.delete(carManufacturerId)
        sessionFactory.currentSession.flush()

        then:
        carManufacturerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CarManufacturer carManufacturer = new CarManufacturer()
        carManufacturerService.save(carManufacturer)

        then:
        carManufacturer.id != null
    }
}
