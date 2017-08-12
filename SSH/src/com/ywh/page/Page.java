package com.ywh.page;

import java.util.List;
//��ҳ��
public class Page {
	//Ҫ��ʾ�����е�����
	private List<?> data;
	//�ܹ���������¼
	private int allRow;
	//ÿһҳ��ʾ����������
	private int pageSize;
	//�ܹ��ж���ҳ
	private int totalPage;
	//��ǰ�ڵڼ�ҳ
	private int currentPage;
	//�Ƿ�����һҳ
	private boolean hasNextPage;
	//�Ƿ�����һҳ
	private boolean hasPrePage;
	//�Ƿ��ǵ�һҳ
	private boolean isFirstPage;
	//�Ƿ������һҳ
	private boolean isLastPage;
	//ͨ�����췽������Ҫ��ʾ�����е�����
	public Page(List<?> data){
		this.data = data;
	} 
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow; 
	} 
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		totalPage=(allRow%pageSize)==0?(allRow/pageSize):(allRow/pageSize+1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isHasNextPage() {
		if(currentPage==totalPage){
			return false;
		}else{
			return true;
		}
		
	}
//	public void setHasNextPage(boolean hasNextPage) {
//		this.hasNextPage = hasNextPage;
//	}
	public boolean isHasPrePage() {
		if(currentPage==1){
			return false;
		}else{
			return true;
		}
	}
//	public void setHasPrePage(boolean hasPrePage) {
//		this.hasPrePage = hasPrePage;
//	}
	public boolean isFirstPage() {
		if(currentPage==1){
			return true;
		}else{
			return false;
		}
	}
//	public void setFirstPage(boolean isFirstPage) {
//		this.isFirstPage = isFirstPage;
//	}
	public boolean isLastPage() {
		if(currentPage==totalPage){
			return true;
		}else{
			return false;
		}
	}
//	public void setLastPage(boolean isLastPage) {
//		this.isLastPage = isLastPage;
//	}
	

}
