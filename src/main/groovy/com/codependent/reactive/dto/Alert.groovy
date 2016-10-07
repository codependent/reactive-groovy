package com.codependent.reactive.dto

class Alert {

	def Integer accountId
	def String message
	
	Alert() {}
	
	Alert(Integer accountId, String message){
		this.accountId = accountId
		this.message = message
	}
	
}
