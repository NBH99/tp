package seedu.address.model.insurancepolicy;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents an InsurancePolicy in the address book.
 * Guarantees: immutable;
 */
public class InsurancePolicy {

    public static final String CHECK_POLICY_ID_REGEX = "Policy_[0-9]{4}";
    public static final String CHECK_POLICY_INPUT_REGEX = "Policy_[0-9]{4}(>.*)?";
    public static final String MESSAGE_CONSTRAINTS = "PolicyIDs should be of the form 'Policy_****'. URLs should be "
            + "preceded by '>' after the PolicyID.";

    public final String policyId;
    private String policyUrl;

    /**
     * Constructs an {@code InsurancePolicy} without URL.
     *
     * @param policyId the Id associated with the policy.
     */
    public InsurancePolicy(String policyId) {
        requireNonNull(policyId);
        this.policyId = policyId;
        this.policyUrl = null;
    }

    /**
     * Constructs an {@code InsurancePolicy} with URL.
     *
     * @param policyId the Id associated with the policy.
     * @param url the URL to the policy document.
     */
    public InsurancePolicy(String policyId, String url) {
        this.policyId = policyId;
        this.policyUrl = url;
    }

    /**
     * Retrieves the {@code policyUrl} associated with this policy.
     *
     * @return the {@code policyUrl} in {@code Optional<String>}.
     */
    public Optional<String> getPolicyUrlIfPresent() {
        return Optional.ofNullable(policyUrl);
    }

    /**
     * Checks if another object is the equal to this policy by comparing policy Id and policy URL.
     *
     * @param other the other object.
     * @return true if the object is equal to this policy.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof InsurancePolicy)) {
            return false;
        }

        InsurancePolicy otherPolicy = (InsurancePolicy) other;

        try {
            return policyId.equals(otherPolicy.policyId) && policyUrl.equals(otherPolicy.policyUrl);
        } catch (NullPointerException e) {
            return policyId.equals(otherPolicy.policyId);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyUrl, policyId);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        if (policyUrl == null) {
            return policyId + ": No URL!";
        }
        return policyId + ": " + policyUrl + "";
    }

    /**
     * Sets policy URL for this insurance policy.
     *
     * @param url to this policy's document.
     */
    public void setPolicyUrl(String url) {
        policyUrl = url;
    }

    /**
     * Checks if given {@code String} is a valid policy Id of the format Policy_****.
     *
     * @param test {@code String} to test.
     * @return true if {@code String} is of valid policy Id format.
     */
    public static boolean isPolicyId(String test) {
        return test.matches(CHECK_POLICY_ID_REGEX);
    }

    /**
     * Checks if given {@code String} is of a valid input format for this command.
     *
     * @param test {@code String} to test.
     * @return true if {@code String} is of a valid input format for this command.
     */
    public static boolean isValidPolicyInput(String test) {
        return test.matches(CHECK_POLICY_INPUT_REGEX);
    }
}
