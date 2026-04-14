package Backend.ArturoWeb.Service;

import Backend.ArturoWeb.Entity.Inquiry;
import Backend.ArturoWeb.Enum.InquiryStatus;
import Backend.ArturoWeb.Repository.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public Optional<Inquiry> getInquiryById(Long id) {
        return inquiryRepository.findById(id);
    }

    public Inquiry createInquiry(Inquiry inquiry) {
        inquiry.setCreatedAt(new Date());
        inquiry.setStatus(InquiryStatus.NEW);
        return inquiryRepository.save(inquiry);
    }

    public Inquiry updateInquiry(Long id, Inquiry inquiryDetails) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquiry no encontrada con id: " + id));

        inquiry.setName(inquiryDetails.getName());
        inquiry.setEmail(inquiryDetails.getEmail());
        inquiry.setMessage(inquiryDetails.getMessage());
        inquiry.setArtworkId(inquiryDetails.getArtworkId());

        if (inquiryDetails.getStatus() != null) {
            inquiry.setStatus(inquiryDetails.getStatus());
        }

        return inquiryRepository.save(inquiry);
    }

    public void deleteInquiry(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inquiry no encontrada con id: " + id));

        inquiryRepository.delete(inquiry);
    }
}