package su.yuk1chan.producerservice.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import su.yuk1chan.producerservice.entity.Producer;
import su.yuk1chan.producerservice.enums.Status;

import java.util.List;

public class ProducerSpecification {
    public static Specification<Producer> firstNameFilter(List<String> firstNames) {
        return (root, _, _) ->
                (firstNames == null || firstNames.isEmpty()) ? null : root.get("firstName").in(firstNames);
    }

    public static Specification<Producer> lastNameFilter(List<String> lastNames) {
        return (root, _, _) ->
                (lastNames == null || lastNames.isEmpty()) ? null : root.get("lastName").in(lastNames);
    }

    public static Specification<Producer> companyFilter(String company) {
        return (root, _, builder) ->
                (company == null || company.isEmpty()) ? null : builder.like(builder.lower(root.get("company")), "%" + company.trim().toLowerCase() + "%");
    }

    public static Specification<Producer> phoneNumberFilter(List<String> phoneNumbers) {
        return (root, _, _) ->
                (phoneNumbers == null || phoneNumbers.isEmpty()) ? null : root.get("phoneNumber").in(phoneNumbers);
    }

    public static Specification<Producer> emailFilter(List<String> emails) {
        return (root, _, _) ->
                (emails == null || emails.isEmpty()) ? null : root.get("email").in(emails);
    }

    public static Specification<Producer> statusFilter(Status status) {
        return (root, _, builder) ->
                status == null ? null : builder.equal(root.get("status"), status);
    }
}
