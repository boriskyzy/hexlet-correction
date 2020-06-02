package io.hexlet.hexletcorrection.service;

import io.hexlet.hexletcorrection.domain.Typo;
import io.hexlet.hexletcorrection.repository.TypoRepository;
import io.hexlet.hexletcorrection.service.mapping.TypoMapper;
import io.hexlet.hexletcorrection.web.vm.TypoReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TypoService {

    private final TypoRepository repository;

    private final TypoMapper mapper;

    public Typo addTypoReport(TypoReport typoReport) {
        return repository.save(mapper.typoReportToTypo(typoReport));
    }
}
