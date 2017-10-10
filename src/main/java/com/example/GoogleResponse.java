package com.example;

public class GoogleResponse {
		private String speech;//": "Barack Hussein Obama II was the 44th and current President of the United States.",
		private String displayText;//": "Barack Hussein Obama II was the 44th and current President of the United States, and the first African American to hold the office. Born in Honolulu, Hawaii, Obama is a graduate of Columbia University   and Harvard Law School, where ",
		private String source;//": "DuckDuckGo"
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDisplayText() {
			return displayText;
		}
		public void setDisplayText(String displayText) {
			this.displayText = displayText;
		}
		public String getSpeech() {
			return speech;
		}
		public void setSpeech(String speech) {
			this.speech = speech;
		}
		
}
