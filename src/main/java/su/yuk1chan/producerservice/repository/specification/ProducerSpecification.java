package su.yuk1chan.producerservice.repository.specification;


import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import su.yuk1chan.producerservice.entity.Producer;
import su.yuk1chan.producerservice.enums.Status;

import java.util.List;

public class ProducerSpecification {
    public static Specification<Producer> firstNameFilter(String firstName) {
        return (root, _, builder) ->
            (firstName == null || firstName.isEmpty()) ? null : builder.like(
                    builder.lower(root.get("firstName")),
                    "%" + firstName.trim().toLowerCase() + "%"
            );
    }

    public static Specification<Producer> firstNamesFilter(List<String> firstNames) {
        return (root, _, builder) -> {
            if (firstNames == null || firstNames.isEmpty()) {
                    return null;
            }

            Predicate[] predicates = firstNames.stream()
                      .map(String::trim)
                      .filter(firstName -> !firstName.isEmpty())
                      .map(firstName -> builder.like(
                              builder.lower(root.get("firstName")),
                                      "%" + firstName.toLowerCase() + "%"
                              )
                      )
                      .toArray(Predicate[]::new);

            if (predicates.length == 0) {
                  return null;
            }

            return builder.or(predicates);
        };
    }

    public static Specification<Producer> lastNamesFilter(List<String> lastNames) {
        return (root, _, builder) -> {
            if (lastNames == null || lastNames.isEmpty()) {
                return null;
            }

            Predicate[] predicates = lastNames.stream()
                    .map(String::trim)
                    .filter(lastName -> !lastName.isEmpty())
                    .map(lastName -> builder.like(
                            builder.lower(root.get("lastName")),
                                    "%" + lastName.toLowerCase() + "%"
                            )
                    )
                    .toArray(Predicate[]::new);

            if (predicates.length == 0) {
                return null;
            }

            return builder.or(predicates);
        };
    }

    public static Specification<Producer> lastNameFilter(String lastName) {
        return (root, _, builder) ->
                (lastName == null || lastName.isEmpty()) ? null : builder.like(
                        builder.lower(root.get("lastName")),
                        "%" + lastName.toLowerCase() + "%"
                );
    }

    public static Specification<Producer> companyFilter(String company) {
        return (root, _, builder) ->
                (company == null || company.isEmpty()) ? null : builder.like(
                        builder.lower(root.get("company")),
                        "%" + company.trim().toLowerCase() + "%"
                );
    }

    public static Specification<Producer> companiesFilter(List<String> companies) {
        return (root, _, builder) -> {
            if (companies == null || companies.isEmpty()) {
                return null;
            }

            Predicate[] predicates = companies.stream()
                .map(String::trim)
                .filter(company -> !company.isEmpty())
                .map(company -> builder.like(
                                builder.lower(root.get("company")),
                                "%" + company.toLowerCase() + "%")
                )
                .toArray(Predicate[]::new);

            if (predicates.length == 0) {
                return null;
            }

            return builder.or(predicates);
        };
    }

    public static Specification<Producer> phoneNumberFilter(String phoneNumber) {
        return (root, _, builder) ->
                (phoneNumber == null || phoneNumber.isEmpty()) ? null : builder.like(
                        builder.lower(root.get("phoneNumber")),
                        "%" + phoneNumber.trim().toLowerCase() + "%"
                );
    }

    public static Specification<Producer> phoneNumbersFilter(List<String> phoneNumbers) {
        return (root, _, builder) -> {
            if (phoneNumbers == null || phoneNumbers.isEmpty()) {
                return null;
            }

            Predicate[] predicates = phoneNumbers.stream()
                    .map(String::trim)
                    .filter(phoneNumber -> !phoneNumber.isEmpty())
                    .map(phoneNumber -> builder.like(
                                    builder.lower(root.get("phoneNumber")),
                                    "%" + phoneNumber.toLowerCase() + "%"
                            )
                    )
                    .toArray(Predicate[]::new);

            if (predicates.length == 0) {
                return null;
            }

            return builder.or(predicates);
        };
    }

    public static Specification<Producer> emailFilter(String email) {
        return (root, _, builder) ->
                (email == null || email.isEmpty()) ? null : builder.like(builder.lower(
                        root.get("email")),
                        "%" + email.trim().toLowerCase() + "%");
    }

    public static Specification<Producer> emailsFilter(List<String> emails) {
        return (root, _, builder) -> {
            if (emails == null || emails.isEmpty()) {
                return null;
            }

            Predicate[] predicates = emails.stream()
                    .map(String::trim)
                    .filter(email -> !email.isEmpty())
                    .map(email -> builder.like(
                                    builder.lower(root.get("email")),
                                    "%" + email.toLowerCase() + "%"
                            )
                    )
                    .toArray(Predicate[]::new);

            if (predicates.length == 0) {
                return null;
            }

            return builder.or(predicates);
        };
    }

    public static Specification<Producer> statusFilter(Status status) {
        return (root, _, builder) ->
                status == null ? null : builder.equal(root.get("status"), status);
    }
}
