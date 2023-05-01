package Models;

public class DocumentType {
    private String id;
    private String name;
    private String description="";
    private String[] attachmentStages={"CERTIFICATE"};
    private String schoolID;
   private boolean active=true;
    private boolean required=true;
    private boolean useCamera=false;
    private String[] translateName={};
    private String schoolId="6390f3207a3bcb6a7ac977f9";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getAttachmentStages() {
        return attachmentStages;
    }

    public void setAttachmentStages(String[] attachmentStages) {
        this.attachmentStages = attachmentStages;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isUseCamera() {
        return useCamera;
    }

    public void setUseCamera(boolean useCamera) {
        this.useCamera = useCamera;
    }

    public String[] getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String[] translateName) {
        this.translateName = translateName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
