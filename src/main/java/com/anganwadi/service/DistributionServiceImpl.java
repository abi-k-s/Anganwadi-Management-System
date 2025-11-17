package com.anganwadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anganwadi.exception.InsufficientStockException;
import com.anganwadi.model.Distribution;
import com.anganwadi.model.Item;
import com.anganwadi.repository.DistributionRepository;
import com.anganwadi.repository.ItemRepository;

@Service
public class DistributionServiceImpl implements DistributionService {

	@Autowired
	private DistributionRepository distributionRepository;
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Distribution> getAll() {
		return distributionRepository.findAll();
	}

	@Override
	public Distribution getById(Long id) {

		Optional<Distribution> optional = distributionRepository.findById(id);
		Distribution distribution = null;
		if (optional.isPresent()) {
			distribution = optional.get();
		} else {
			throw new RuntimeException("Item not found for id : " + id);
		}
		return distribution;
	}

	@Override
	public void save(Distribution distribution) {

		Distribution existing = null;

		if (distribution.getId() != null) {
			existing = distributionRepository.findById(distribution.getId())
					.orElseThrow(() -> new RuntimeException("Distribution not found"));
			Integer Qty = existing.getQuantity();
			Long itemId = distribution.getItem().getId();
			Item item = itemRepository.findById(itemId)
					.orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
			if (item.getQuantity() < distribution.getQuantity()) {
				throw new InsufficientStockException(
						"Only " + item.getQuantity() + " units available for item: " + item.getItemName());
			}
			Integer totalQuantity = Qty + item.getQuantity();
			item.setQuantity(totalQuantity - distribution.getQuantity());
			itemRepository.save(item);

		} else {

			Long itemId = distribution.getItem().getId();
			Item item = itemRepository.findById(itemId)
					.orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

			if (item.getQuantity() == null) {
				throw new RuntimeException("Item quantity is null for item ID: " + itemId);
			}

			Integer currentQty = item.getQuantity();
			Integer distributionQty = distribution.getQuantity();

			if (currentQty < distributionQty) {
				throw new InsufficientStockException(
						"Only " + currentQty + " units available for item: " + item.getItemName());
			}

			item.setQuantity(item.getQuantity() - distributionQty);
			itemRepository.save(item);
		}
		distributionRepository.save(distribution);
	}

	@Override
	public void delete(Long id) {
		distributionRepository.deleteById(id);
	}

	@Override
	public boolean isItemAlreadyDistributed(Long womanId, String month, String itemName, Integer year) {
		return distributionRepository.existsByWomanIdAndMonthAndItem_ItemNameAndYear(womanId, month, itemName, year);
	}

}