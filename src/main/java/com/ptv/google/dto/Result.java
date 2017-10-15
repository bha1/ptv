package com.ptv.google.dto;

public class Result {
	private String source;
	private String resolvedQuery;
	private String speech;
	private String action;
	private boolean actionIncomplete;
	private Object fulfillment;
	private Integer score;
	private Parameters parameters;
	private Object[] contexts;
	private Metadata metadata;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getResolvedQuery() {
		return resolvedQuery;
	}
	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isActionIncomplete() {
		return actionIncomplete;
	}
	public void setActionIncomplete(boolean actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
	}
	public Object getFulfillment() {
		return fulfillment;
	}
	public void setFulfillment(Object fulfillment) {
		this.fulfillment = fulfillment;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public Object[] getContexts() {
		return contexts;
	}
	public void setContexts(Object[] contexts) {
		this.contexts = contexts;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}
