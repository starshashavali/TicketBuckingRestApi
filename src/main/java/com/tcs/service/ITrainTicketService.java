package com.tcs.service;

import com.tcs.dto.CustomerDTO;
import com.tcs.dto.TicketDTO;

public interface ITrainTicketService {

	public TicketDTO bookBusTicket(CustomerDTO dto);

	public TicketDTO getBusTicket(Integer ticketNum);

}
