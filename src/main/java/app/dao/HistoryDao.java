package app.dao;

import java.util.List;

import app.dto.HistoryDto;

public interface HistoryDao {
	public void createHistory(HistoryDto historyDto) throws Exception;
	public List<HistoryDto> findHistory(HistoryDto historyDto) throws Exception;

}
