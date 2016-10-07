package com.codependent.reactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import reactor.core.publisher.Flux

import com.codependent.reactive.dto.Alert

@RestController
@RequestMapping("/accounts")
class AccountRestController {
	
    @GetMapping("/{accountId}/alerts")
    Flux<Alert> getAccountAlerts(@PathVariable Integer accountId) {
		Flux.range(1, 10)
			.map( { i  -> return new Alert(i, "Alert message"+i) })
			.delayMillis(500)
			.log();
    }
	
	@GetMapping(value="/{accountId}/alerts/live", produces="text/event-stream")
	Flux<Alert> getAccountAlertsStreaming(@PathVariable Integer accountId) {
		Flux.range(1, 50)
			.map( { i  -> return new Alert(i, "Alert message"+i) })
			.delayMillis(1000)
			.log();
	}
	
}