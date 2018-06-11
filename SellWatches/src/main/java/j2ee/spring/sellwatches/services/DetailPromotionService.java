package j2ee.spring.sellwatches.services;

import java.util.List;

import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.viewmodel.DetailPromotionViewModel;


@Component
public interface DetailPromotionService extends MSSQLService<DetailPromotion>{

	List<DetailPromotionViewModel> getList(String id);

}
