package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Record;
import by.vadarod.nikolatyk_v.repository.RecordRepository;
import by.vadarod.nikolatyk_v.repository.RecordRepositoryImpl;
import org.hibernate.SessionFactory;

public class RecordService {
    private final SessionFactory sessionFactory;
    public RecordService(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public Long addRecord(Record record){
        RecordRepository recordRepository = new RecordRepositoryImpl(sessionFactory);
        return recordRepository.addRecord(record);
    }
}
