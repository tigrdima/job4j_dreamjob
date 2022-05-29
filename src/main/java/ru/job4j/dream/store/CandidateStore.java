package ru.job4j.dream.store;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.dream.model.Candidate;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CandidateStore {
    private final AtomicInteger id = new AtomicInteger(4);
    private static final CandidateStore INST = new CandidateStore();
    private final Map<Integer, Candidate> candidates = new HashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Java-программист",
                "Знание языка Java на профессиональном уровне. Опыт работы с технологиями Spring Framework.",
                new Date().toString()));
        candidates.put(2, new Candidate(2, "Java Developer",
                "Разработка и оптимизация сервисов/микросервисов на Java/Kotlin.",
                new Date().toString()));
        candidates.put(3, new Candidate(3, "Разработчик Java",
                "Участвовать в качестве разработчика в проекте по созданию и развитию Платёжной Системы Банка России. ",
                new Date().toString()));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public void add(Candidate candidate) {
        candidate.setId(id.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

}
