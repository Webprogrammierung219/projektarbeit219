package de.dhbw.ravensburg.wp.be219thenextchapter.mapper;

import de.dhbw.ravensburg.wp.be219thenextchapter.dto.BusDTO;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.Bus;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusRoute;
import de.dhbw.ravensburg.wp.be219thenextchapter.model.BusSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BusMapper {

   //die Ids der BusLinien werden in die Variable BusRouteIds geschrieben -> mapping
    @Mapping(target = "busScheduleIds", source = "busSchedules") //Ids aus source werden auf target also DTO gemapped, target kommt aus DTO, source aus model
    BusDTO busToBusDTO(Bus bus);
    List<BusDTO> bussesToBusDTOs(List<Bus> busses);

    Bus busDTOToBus (BusDTO busDTO);
    List<Bus> busDTOsToBusses (List<BusDTO> busDTOs);

    //holt die Ids des Busfahrplans
    default Long map(BusSchedule busSchedule){
        return busSchedule.getId();
     }

}
