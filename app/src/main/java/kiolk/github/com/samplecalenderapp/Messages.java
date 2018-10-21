package kiolk.github.com.samplecalenderapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by anna.krajnik on 01.03.2016.
 */
public class Messages implements Serializable {
    private String id;
    private String version;
    private String createdBy;
    private String updatedBy;
    private boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private String messageType;
    private String topic;
    private Date dueDate;
    private Date startDate;
    private Date endDate;
    private Date oldTime;
    private Date newTime;
    private String schoolClassId;
    private String content;
    private String recipientsType;
    private int recipientsCount;
    private boolean isCompletedBySender;
    private String[] relatedPupilsNames;
    private String messageProperties;
    private String pupilId;
    private String pupilName;
    private String pupilNameForParent;
    private int numberSigned;
    private int numberAttending;
    private boolean isDone;
    private boolean isOwned;
    private boolean isRead;
    private boolean isSigned;
    private boolean isAttending;
    private Date eventDate;
    private String senderName;
    private int instantMessagesCount;
    private boolean instantMessagesAllowed = true;
    private boolean hasUnreadInstantMessages;
    private boolean isPremium;
    private boolean allowMultipleSurveyOptions;
    private boolean arePupilsInvited;
    private Integer maxPupilParticipants;
    private Date pupilRegistratioOpenUntil;
    private boolean areParentsInvited;
    private Integer maxParentParticipants;
    private Date parentRegistratioOpenUntil;
    private int numberAttendingPupils;
    private int numberAttendingParents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRecipientsCount() {
        return recipientsCount;
    }

    public void setRecipientsCount(int recipientsCount) {
        this.recipientsCount = recipientsCount;
    }

    public String getRecipientsType() {
        return recipientsType;
    }

    public void setRecipientsType(String recipientsType) {
        this.recipientsType = recipientsType;
    }

    public String getMessageProperties() {
        return messageProperties;
    }

    public JSONObject getMessagePropertiesAsJSON() {
        try {
            return new JSONObject(messageProperties);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public void setMessageProperties(String messageProperties) {
        this.messageProperties = messageProperties;
    }

    public Date getOldTime() {
        return oldTime;
    }

    public void setOldTime(Date oldTime) {
        this.oldTime = oldTime;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    public boolean isCompletedBySender() {
        return isCompletedBySender;
    }

    public void setIsCompletedBySender(boolean isCompletedBySender) {
        this.isCompletedBySender = isCompletedBySender;
    }


    public String[] getRelatedPupilsNames() {
        return relatedPupilsNames;
    }

    public void setRelatedPupilsNames(String[] relatedPupilsNames) {
        this.relatedPupilsNames = relatedPupilsNames;
    }

    public boolean haveAppointmentsDate() {
        return getAppointmentsDate() != null;
    }

    public Date getAppointmentsDate() {
        if (startDate != null) {
            return startDate;
        }
        if (dueDate != null) {
            return dueDate;
        }
        if (newTime != null) {
            return newTime;
        }
        return null;
    }


    public String getPupilId() {
        return pupilId;
    }

    public void setPupilId(String pupilId) {
        this.pupilId = pupilId;
    }

    public String getPupilName() {
        return pupilName;
    }

    public void setPupilName(String pupilName) {
        this.pupilName = pupilName;
    }

    public String getPupilNameForParent() {
        return pupilNameForParent;
    }

    public void setPupilNameForParent(String pupilNameForParent) {
        this.pupilNameForParent = pupilNameForParent;
    }

    public int getNumberSigned() {
        return numberSigned;
    }

    public void setNumberSigned(int numberSigned) {
        this.numberSigned = numberSigned;
    }

    public int getNumberAttending() {
        return numberAttending;
    }

    public void setNumberAttending(int numberAttending) {
        this.numberAttending = numberAttending;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setIsSigned(boolean isSigned) {
        this.isSigned = isSigned;
    }

    public boolean isAttending() {
        return isAttending;
    }

    public void setIsAttending(boolean isAttending) {
        this.isAttending = isAttending;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getInstantMessagesCount() {
        return instantMessagesCount;
    }

    public void setInstantMessagesCount(int instantMessagesCount) {
        this.instantMessagesCount = instantMessagesCount;
    }

    public boolean isInstantMessagesAllowed() {
        return instantMessagesAllowed;
    }

    public void setInstantMessagesAllowed(boolean instantMessagesAllowed) {
        this.instantMessagesAllowed = instantMessagesAllowed;
    }

    public boolean isHasUnreadInstantMessages() {
        return hasUnreadInstantMessages;
    }

    public void setHasUnreadInstantMessages(boolean hasUnreadInstantMessages) {
        this.hasUnreadInstantMessages = hasUnreadInstantMessages;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isAllowMultipleSurveyOptions() {
        return allowMultipleSurveyOptions;
    }

    public void setAllowMultipleSurveyOptions(boolean allowMultipleSurveyOptions) {
        this.allowMultipleSurveyOptions = allowMultipleSurveyOptions;
    }

    public boolean isArePupilsInvited() {
        return arePupilsInvited;
    }

    public void setArePupilsInvited(boolean arePupilsInvited) {
        this.arePupilsInvited = arePupilsInvited;
    }

    public Integer getMaxPupilParticipants() {
        return maxPupilParticipants;
    }

    public void setMaxPupilParticipants(Integer maxPupilParticipants) {
        this.maxPupilParticipants = maxPupilParticipants;
    }

    public Date getPupilRegistratioOpenUntil() {
        return pupilRegistratioOpenUntil;
    }

    public void setPupilRegistratioOpenUntil(Date pupilRegistratioOpenUntil) {
        this.pupilRegistratioOpenUntil = pupilRegistratioOpenUntil;
    }

    public boolean isAreParentsInvited() {
        return areParentsInvited;
    }

    public void setAreParentsInvited(boolean areParentsInvited) {
        this.areParentsInvited = areParentsInvited;
    }

    public Integer getMaxParentParticipants() {
        return maxParentParticipants;
    }

    public void setMaxParentParticipants(Integer maxParentParticipants) {
        this.maxParentParticipants = maxParentParticipants;
    }

    public Date getParentRegistratioOpenUntil() {
        return parentRegistratioOpenUntil;
    }

    public void setParentRegistratioOpenUntil(Date parentRegistratioOpenUntil) {
        this.parentRegistratioOpenUntil = parentRegistratioOpenUntil;
    }

    public int getNumberAttendingPupils() {
        return numberAttendingPupils;
    }

    public void setNumberAttendingPupils(int numberAttendingPupils) {
        this.numberAttendingPupils = numberAttendingPupils;
    }

    public int getNumberAttendingParents() {
        return numberAttendingParents;
    }

    public void setNumberAttendingParents(int numberAttendingParents) {
        this.numberAttendingParents = numberAttendingParents;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Messages && ((Messages) o).id == id;
    }

    @Override
    public Messages clone() {
        Messages message = new Messages();
        message.setId(getId());
        message.setVersion(getVersion());
        message.setCreatedBy(getCreatedBy());
        message.setUpdatedBy(getUpdatedBy());
        message.setIsActive(isActive());
        message.setCreatedAt(getCreatedAt());
        message.setUpdatedAt(getUpdatedAt());
        message.setMessageType(getMessageType());
        message.setTopic(getTopic());
        message.setDueDate(getDueDate());
        message.setStartDate(getStartDate());
        message.setEndDate(getEndDate());
        message.setOldTime(getOldTime());
        message.setNewTime(getNewTime());
        message.setSchoolClassId(getSchoolClassId());
        message.setContent(getContent());
        message.setRecipientsCount(getRecipientsCount());
        message.setRecipientsType(getRecipientsType());
        message.setIsCompletedBySender(isCompletedBySender());
        message.setMessageProperties(getMessageProperties());
        message.setPupilId(getPupilId());
        message.setPupilName(getPupilName());
        message.setPupilNameForParent(getPupilNameForParent());
        message.setNumberSigned(getNumberSigned());
        message.setNumberAttending(getNumberAttending());
        message.setIsDone(isDone());
        message.setIsOwned(isOwned());
        message.setIsRead(isRead());
        message.setIsSigned(isSigned());
        message.setIsAttending(isAttending());
        message.setEventDate(getEventDate());
        message.setSenderName(getSenderName());
        message.setInstantMessagesCount(getInstantMessagesCount());
        message.setInstantMessagesAllowed(isInstantMessagesAllowed());
        message.setHasUnreadInstantMessages(isHasUnreadInstantMessages());
        message.setPremium(isPremium());
        message.setAllowMultipleSurveyOptions(isAllowMultipleSurveyOptions());
        message.setArePupilsInvited(isArePupilsInvited());
        message.setMaxPupilParticipants(getMaxPupilParticipants());
        message.setPupilRegistratioOpenUntil(getPupilRegistratioOpenUntil());
        message.setAreParentsInvited(isAreParentsInvited());
        message.setMaxParentParticipants(getMaxParentParticipants());
        message.setParentRegistratioOpenUntil(getParentRegistratioOpenUntil());
        message.setNumberAttendingPupils(getNumberAttendingPupils());
        message.setNumberAttendingParents(getNumberAttendingParents());

        return message;
    }
}
