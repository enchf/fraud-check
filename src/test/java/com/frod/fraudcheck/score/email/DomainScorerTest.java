package com.frod.fraudcheck.score.email;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.frod.fraudcheck.TestHelper;
import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.domain.Email;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class DomainScorerTest implements TestHelper {

    @Mock
    private YAMLConfiguration yamlConfiguration;

    @InjectMocks
    private DomainScorer domainScorer;

    private List<String> domains;

    private static final int MAX_NUM_OF_DOMAINS = 4;
    private static final Supplier<String> DOMAIN_SUPPLIER = () -> TestHelper.FAKER.internet().domainName();

    @Before
    public void setup() {
        domains = Stream.generate(DOMAIN_SUPPLIER)
                        .limit(MAX_NUM_OF_DOMAINS)
                        .distinct()
                        .collect(Collectors.toList());
        when(yamlConfiguration.getAcceptedDomains()).thenReturn(domains);
    }

    private String buildEmail(String account, String domain) {
        return String.format("%s@%s", account, domain);
    }

    @Test
    public void score() {
        String domain = domains.get(faker().number().numberBetween(0, domains.size() - 1));
        String account = faker().name().username();
        String email = buildEmail(account, domain);
        assertThat(domainScorer.score(new Email(email, domain, account))).isEqualTo(DomainScorer.SUCCESS);
    }

    @Test
    public void unrecognizedDomain() {
        String account = faker().name().username();
        String domain = Stream.generate(DOMAIN_SUPPLIER)
                              .filter(candidate -> !domains.contains(candidate))
                              .findFirst().get();
        String email = buildEmail(account, domain);
        assertThat(domainScorer.score(new Email(email, domain, account))).isEqualTo(DomainScorer.FAIL);
    }
}
