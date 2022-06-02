package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.CandidateDBStore;

import java.util.Collection;

@ThreadSafe
@Service
public class CandidateService {
    private final CandidateDBStore  candidateDBStore;

    public CandidateService(CandidateDBStore candidateDBStore) {
        this.candidateDBStore = candidateDBStore;
    }

    public void add(Candidate candidate) {
        candidateDBStore.add(candidate);
    }

    public void update(Candidate candidate) {
        candidateDBStore.update(candidate);
    }

    public Candidate findById(int id) {
        return candidateDBStore.findById(id);
    }

    public Collection<Candidate> findAll() {
        return candidateDBStore.findAll();
    }

}

