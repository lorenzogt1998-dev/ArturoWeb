package Backend.ArturoWeb.Controller;

import Backend.ArturoWeb.DTO.InquiryRequestDTO;
import Backend.ArturoWeb.DTO.InquiryResponseDTO;
import Backend.ArturoWeb.Entity.Inquiry;
import Backend.ArturoWeb.Mapper.InquiryMapper;
import Backend.ArturoWeb.Service.InquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping
    public List<InquiryResponseDTO> getAllInquiries() {
        return inquiryService.getAllInquiries()
                .stream()
                .map(InquiryMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InquiryResponseDTO> getInquiryById(@PathVariable Long id) {
        return inquiryService.getInquiryById(id)
                .map(inquiry -> ResponseEntity.ok(InquiryMapper.toDTO(inquiry)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InquiryResponseDTO createInquiry(@RequestBody InquiryRequestDTO dto) {
        Inquiry inquiry = InquiryMapper.toEntity(dto);
        Inquiry savedInquiry = inquiryService.createInquiry(inquiry);
        return InquiryMapper.toDTO(savedInquiry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InquiryResponseDTO> updateInquiry(@PathVariable Long id,
                                                            @RequestBody InquiryRequestDTO dto) {
        try {
            Inquiry inquiryDetails = InquiryMapper.toEntity(dto);
            Inquiry updatedInquiry = inquiryService.updateInquiry(id, inquiryDetails);
            return ResponseEntity.ok(InquiryMapper.toDTO(updatedInquiry));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        try {
            inquiryService.deleteInquiry(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}