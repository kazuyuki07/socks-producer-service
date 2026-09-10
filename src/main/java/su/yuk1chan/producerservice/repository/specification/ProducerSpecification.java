package su.yuk1chan.producerservice.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import su.yuk1chan.producerservice.entity.Producers;
import su.yuk1chan.producerservice.enums.Status;

import java.util.List;

public class ProducerSpecification {
    public static Specification<Producers> firstNameFilter(List<String> firstNames) {
        return (root, _, _) ->
                (firstNames == null || firstNames.isEmpty()) ? null : root.get("firstName").in(firstNames);
    }

    public static Specification<Producers> lastNameFilter(List<String> lastNames) {
        return (root, _, _) ->
                (lastNames == null || lastNames.isEmpty()) ? null : root.get("lastName").in(lastNames);
    }

    public static Specification<Producers> companyFilter(List<String> companies) {
        return (root, _, _) ->
                (companies == null || companies.isEmpty()) ? null : root.get("company").in(companies);
    }

    public static Specification<Producers> phoneNumberFilter(List<String> phoneNumbers) {
        return (root, _, _) ->
                (phoneNumbers == null || phoneNumbers.isEmpty()) ? null : root.get("phoneNumber").in(phoneNumbers);
    }

    public static Specification<Producers> emailFilter(List<String> emails) {
        return (root, _, _) ->
                (emails == null || emails.isEmpty()) ? null : root.get("email").in(emails);
    }

    public static Specification<Producers> statusFilter(Status status) {
        return (root, _, builder) ->
                status == null ? null : builder.equal(root.get("status"), status);
    }
}
