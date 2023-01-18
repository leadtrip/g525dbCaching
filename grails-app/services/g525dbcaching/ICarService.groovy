package g525dbcaching

interface ICarService {
    Car get(Serializable id)

    List<Car> list(Map args)

    Long count()

    void delete(Serializable id)

    Car save(Car car)
}
