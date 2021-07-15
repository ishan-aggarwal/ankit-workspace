package absencepayrollrequirements.exportcsv;

public class FieldModel {
	private String absenceType;
    private String wageType;
    private String conversionMethod;
    private String consolidationMethod;
    private String reversalMethod;
    private String clawback;
    private String questionnaire;
    private String comments;
	public String getAbsenceType() {
		return absenceType;
	}
	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}
	public String getWageType() {
		return wageType;
	}
	public void setWageType(String wageType) {
		this.wageType = wageType;
	}
	public String getConversionMethod() {
		return conversionMethod;
	}
	public void setConversionMethod(String conversionMethod) {
		this.conversionMethod = conversionMethod;
	}
	public String getConsolidationMethod() {
		return consolidationMethod;
	}
	public void setConsolidationMethod(String consolidationMethod) {
		this.consolidationMethod = consolidationMethod;
	}
	public String getReversalMethod() {
		return reversalMethod;
	}
	public void setReversalMethod(String reversalMethod) {
		this.reversalMethod = reversalMethod;
	}
	public String getClawback() {
		return clawback;
	}
	public void setClawback(String clawback) {
		this.clawback = clawback;
	}
	public String getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(String questionnaire) {
		this.questionnaire = questionnaire;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
