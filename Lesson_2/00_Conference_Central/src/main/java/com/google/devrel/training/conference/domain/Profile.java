package com.google.devrel.training.conference.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.devrel.training.conference.form.ProfileForm.TeeShirtSize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


// TODO indicate that this class is an Entity
@Entity
public class Profile {
	String displayName;
	String mainEmail;
	TeeShirtSize teeShirtSize;
	
	private List<String> conferenceKeysToAttend = new ArrayList<String>(0);

	// TODO indicate that the userId is to be used in the Entity's key
	@Id
	String userId;
    
    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     * 
     */
    public Profile (String userId, String displayName, String mainEmail, TeeShirtSize teeShirtSize) {
    	this.userId = userId;
    	this.displayName = displayName;
    	this.mainEmail = mainEmail;
    	this.teeShirtSize = teeShirtSize;
    }
    
	public String getDisplayName() {
		return displayName;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public TeeShirtSize getTeeShirtSize() {
		return teeShirtSize;
	}
	
	public List<String> getConferenceKeysToAttend() {
		return ImmutableList.copyOf(conferenceKeysToAttend);
	}

	public void addToConferenceKeysToAttend(final String conferenceKey) {
		conferenceKeysToAttend.add(conferenceKey);
	}

	public void unregisterFromConference(final String conferenceKey) {
		if (conferenceKeysToAttend.contains(conferenceKey)) {
			conferenceKeysToAttend.remove(conferenceKey);
		}
		else {
			throw new IllegalArgumentException("Invalid conferenceKey: "+conferenceKey);
		}
	}

	public String getUserId() {
		return userId;
	}
	
	public void update(String newDisplayName, TeeShirtSize newTeeShirtSize) {
		displayName = newDisplayName;
		teeShirtSize = newTeeShirtSize;
	}

	/**
     * Just making the default constructor private.
     */
    @SuppressWarnings("unused")
	private Profile() {}

}
