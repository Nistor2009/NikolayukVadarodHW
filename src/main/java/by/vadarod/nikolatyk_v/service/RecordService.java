package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Record;
import by.vadarod.nikolatyk_v.repository.RecordRepository;
import by.vadarod.nikolatyk_v.repository.RecordRepositoryImpl;
import org.hibernate.SessionFactory;

public class RecordService {
    private final RecordRepository recordRepository;
    public RecordService(SessionFactory sessionFactory){
        recordRepository = new RecordRepositoryImpl(sessionFactory);
    }
    public Long addRecord(Record record){
        return recordRepository.addRecord(record);
    }
}
