package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.config.HibernateJavaConfig;
import by.vadarod.nikolatyk_v.entity.*;
import by.vadarod.nikolatyk_v.entity.Record;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class SportCenterService {

    private final SessionFactory sessionFactory;
    private final ClientService clientService;
    private final SportServService sportServService;
    private final BuildingService buildingService;
    private final VisitorService visitorService;
    private final EmployeeService employeeService;
    private final VisitService visitService;
    private final RecordService recordService;

    public SportCenterService() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
        clientService = new ClientService(sessionFactory);
        sportServService = new SportServService(sessionFactory);
        buildingService = new BuildingService(sessionFactory);
        visitorService = new VisitorService(sessionFactory);
        employeeService = new EmployeeService(sessionFactory);
        visitService = new VisitService(sessionFactory);
        recordService = new RecordService(sessionFactory);
    }

    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    public List<PrimeClient> getAllPrimeClient() {
        return clientService.getAllPrimeClient();
    }

    public Client getClientById(Long id) {
        return clientService.getClientById(id);
    }

    public void addFiveClient() {
        clientService.addFiveClient();
    }

    public Client deleteClientById(Long id) {
        return clientService.deleteClientById(id);
    }

    public Client updateClientState(Long id, ClientStatus state) {
        return clientService.updateClientState(id, state);
    }

    /*
        SportServ
     */
    public SportServ addSportServ(SportServ sportServ) {
        return sportServService.addSportServ(sportServ);
    }

    public SportServ getSportServByName(String name) {
        return sportServService.getSportServByName(name);
    }

    /*
        Building
     */
    public Long addBuilding(Building building) {
        return buildingService.addBuilding(building);
    }

    public Optional<Building> getBuildingById(Long id) {
        return buildingService.getBuildingById(id);
    }

    public Building updateBuildingPricePerHour(Long id, double newPrice) {
        return buildingService.updatePricePerHour(id, newPrice);
    }

    public Building addBuildingWithDetach(Long id, String newNumber) {
        return buildingService.addBuildingWithDetach(id, newNumber);
    }

    public List<Building> getAllSmallBuildings() {
        return buildingService.getAllSmallBuildings();
    }

    /*
    Visitor
     */
    public Long addVisitor(Visitor visitor) {
        return visitorService.add(visitor);
    }

    public List<Visitor> findALlVisitors() {
        return visitorService.findALl();
    }

    public Optional<Visitor> getVisitorById(Long id) {
        return visitorService.getById(id);
    }

    /*
    Employee
     */
    public Employee addEmployee(Employee employee) {
        return employeeService.add(employee);
    }

    public List<Employee> findALlEmployees() {
        return employeeService.findALl();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeService.getById(id);
    }

    /*
    Common
     */
    public void addFourEmployeesAndVisitors() {
        Visitor visitor = new Visitor();
        visitor.setStatus(ClientStatus.ACTIVE.toString());
        visitor.setFirstVisit(new GregorianCalendar(2025, Calendar.AUGUST, 28));
        visitor.setSpentMoney(112.5);
        visitor.setPhone("+375298876524");
        visitor.setName("Вася");
        visitor.setSurname("Пупкин");
        visitor.setAddress(new Address("Минск", "Независимости", "26", "225347"));
        visitor.setAge(39);
        visitor.setLastVisit(new GregorianCalendar(2025, Calendar.AUGUST, 28));
        addVisitor(visitor);
        visitor.setName("Петя");
        visitor.setSurname("Петров");
        addVisitor(visitor);
        visitor.setName("Андрей");
        visitor.setSurname("Дудкин");
        addVisitor(visitor);
        visitor.setName("Антон");
        visitor.setSurname("Антонов");
        addVisitor(visitor);
//-------------------------------------------------------------------
        Employee employee = new Employee();
        employee.setPhone("+375298876524");
        employee.setName("Женя");
        employee.setSurname("Васечкин");
        employee.setAddress(new Address("Минск", "Независимости", "26", "225347"));
        employee.setAge(39);
        employee.setSalary(1850);
        employee.setArrangementDate(new GregorianCalendar(2025, Calendar.AUGUST, 28));
        employee.setJobPosition("Couch");
        addEmployee(employee);
        employee.setName("Вася");
        employee.setSurname("Печкин");
        addEmployee(employee);
        employee.setName("Дональд");
        employee.setSurname("Евгеньев");
        addEmployee(employee);
        employee.setName("Леопольд");
        employee.setSurname("Арнольдов");
        addEmployee(employee);
    }

    public void fillRecordAndVisitTables(){
        Long visitorId;
        Long buildingId;
        //Создаем помещение
        Building building = new Building();
        building.setName("room 1");
        building.setStatus(BuildingStatus.ACTIVE.toString());
        building.setIdentNumber("13");
        building.setMaxPeopleCount(25);
        building.setPricePerHour(150.5);
        buildingId = buildingService.addBuilding(building);
        //Создаем клиента
        Visitor visitor = new Visitor();
        visitor.setName("Галя");
        visitor.setSurname("Куклакова");
        visitor.setAge(56);
        visitor.setStatus(ClientStatus.PRIME.toString());
        visitor.setPhone("+375448945214");
        visitorId = visitorService.add(visitor);
        //Делаем записи
        Record record = new Record();
        record.setBuildingId(buildingId);
        record.setClientId(visitorId);
        record.setDate(LocalDate.of(2025, Month.JUNE,20));
        record.setTime(LocalTime.of(12,0));
        recordService.addRecord(record);
        record = new Record();
        record.setBuildingId(buildingId);
        record.setClientId(visitorId);
        record.setDate(LocalDate.of(2025, Month.JUNE,21));
        record.setTime(LocalTime.of(11,0));
        recordService.addRecord(record);
        record = new Record();
        record.setBuildingId(buildingId);
        record.setClientId(visitorId);
        record.setDate(LocalDate.of(2025, Month.JUNE,22));
        record.setTime(LocalTime.of(17,30));
        recordService.addRecord(record);
    }

}
