package Backend.ArturoWeb.Mapper;

import Backend.ArturoWeb.DTO.EventRequestDTO;
import Backend.ArturoWeb.DTO.EventResponseDTO;
import Backend.ArturoWeb.Entity.Event;

public class EventMapper {

    public static Event toEntity(EventRequestDTO dto) {
        Event event = new Event();
        event.setTitle(dto.title());
        event.setDescription(dto.description());
        event.setLocation(dto.location());
        event.setDate(dto.date());
        event.setImageUrl(dto.imageUrl());
        return event;
    }

    public static EventResponseDTO toDTO(Event event) {
        return new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getLocation(),
                event.getDate(),
                event.getImageUrl()
        );
    }
}