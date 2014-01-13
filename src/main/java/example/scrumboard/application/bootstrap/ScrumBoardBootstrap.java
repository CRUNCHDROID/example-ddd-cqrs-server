package example.scrumboard.application.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import example.ddd.domain.ApplicationBootstrapEvent;
import example.scrumboard.application.finders.ProductFinder;
import example.scrumboard.application.services.BacklogItemService;
import example.scrumboard.application.services.ProductService;
import example.scrumboard.domain.product.ProductId;

@Component
public class ScrumBoardBootstrap implements ApplicationListener<ApplicationBootstrapEvent> {

	@Autowired
	private ProductFinder productFinder;

	@Autowired
	private ProductService productService;

	@Autowired
	private BacklogItemService backlogItemService;

	@Override
	public void onApplicationEvent(ApplicationBootstrapEvent event) {
		if (productFinder.count() == 0) {
			initializeProducts();
		}
	}

	private void initializeProducts() {
		ProductId productId1 = productService.createProduct("Example DDD server");
		backlogItemService.createBacklogItem(productId1, "Write documentation");
		backlogItemService.createBacklogItem(productId1, "Add more unit tests");

		ProductId productId2 = productService.createProduct("Example DDD client");
		// no backlog items
	}

}
