package com.tcs.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tcs.dto.CustomerDTO;
import com.tcs.dto.TicketDTO;
import com.tcs.exception.TicketIdNotFoundException;
import com.tcs.service.ITrainTicketService;
@Service
public class ITrainTicketServiceImpl implements ITrainTicketService{

	private Map<Integer,TicketDTO> ticketMap=new HashMap<>();
	
	private Integer ticketNum=1;
	
	@Override
	public TicketDTO bookBusTicket(CustomerDTO passengerDTO) {
		TicketDTO tickeDto = new TicketDTO();

		BeanUtils.copyProperties(passengerDTO, tickeDto);
		tickeDto.setStatus("Confirmed");
		tickeDto.setCost("200");
		tickeDto.setTicketNum(ticketNum);
		ticketMap.put(ticketNum, tickeDto);
		ticketNum++;
		return tickeDto;
		
	}

	@Override
	public TicketDTO getBusTicket(Integer ticketNum) {
		if(ticketMap.containsKey(ticketNum)) {
			return	ticketMap.get(ticketNum);
			
		}
		throw new TicketIdNotFoundException("IdNot found ::"+ticketNum);
	}

}
