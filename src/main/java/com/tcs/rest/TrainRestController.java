package com.tcs.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.CustomerDTO;
import com.tcs.dto.TicketDTO;
import com.tcs.service.ITrainTicketService;

@RestController
@Valid
public class TrainRestController {
	
	@Autowired
	private ITrainTicketService itrainTicketService;
	
	@PostMapping("/save")
		public ResponseEntity<?> bookBusticket(@Valid @RequestBody CustomerDTO passengerDto) {
			TicketDTO ticket = itrainTicketService.bookBusTicket(passengerDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
		}

		@GetMapping("getticket/{id}")
		public ResponseEntity<?> getBusTicket(@Valid @PathVariable Integer id){
			TicketDTO busTicket = itrainTicketService.getBusTicket(id);
			return ResponseEntity.status(HttpStatus.OK).body(busTicket);
		}


}
