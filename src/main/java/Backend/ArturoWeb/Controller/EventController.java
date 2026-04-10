package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.DTO.EventRequestDTO;
import Backend.ArturoWeb.DTO.EventResponseDTO;
import Backend.ArturoWeb.Entity.Event;
import Backend.ArturoWeb.Mapper.EventMapper;
import Backend.ArturoWeb.Service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventResponseDTO> getAllEvents() {
        return eventService.getAllEvents()
                .stream()
                .map(EventMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(event -> ResponseEntity.ok(EventMapper.toDTO(event)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventResponseDTO createEvent(@RequestBody EventRequestDTO dto) {
        Event event = EventMapper.toEntity(dto);
        Event savedEvent = eventService.createEvent(event);
        return EventMapper.toDTO(savedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable Long id,
                                                        @RequestBody EventRequestDTO dto) {
        try {
            Event eventDetails = EventMapper.toEntity(dto);
            Event updatedEvent = eventService.updateEvent(id, eventDetails);
            return ResponseEntity.ok(EventMapper.toDTO(updatedEvent));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}