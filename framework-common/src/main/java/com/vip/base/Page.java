//package com.vip.base;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author GorgeousNi Created in 2018/5/3 下午4:19
// * @Title: 自定义分页参数
// * @Description:
// */
//public class Page<T> implements Serializable {
//
//  private int pageNum; //起始行
//  private int pageSize;//每页数
//  private long total; //总记录数
//  private int pages;//总页数
//  private int curPage; //当前页
//  private List<T> list;
//
//  /**
//   * 构造方法，只构造空页.
//   */
//  public Page() {
//    this(0, 0, 10, new ArrayList());
//  }
//
//  public Page(int pageSize) {
//    this(0, 0, pageSize, new ArrayList());
//  }
//
//  /**
//   * 默认构造方法.
//   *
//   * @param start 本页数据在数据库中的起始位置
//   * @param totalSize 数据库中总记录条数
//   * @param pageSize 本页容量
//   * @param list 本页包含的数据
//   */
//  public Page(int start, int totalSize, int pageSize, List<T> list) {
//    this.pageSize = pageSize;
//    this.pageNum = start;
//    this.total = totalSize;
//    this.list = list;
//  }
//
//  public Page(int start, int curPage, int totalSize, int pageSize, List<T> list) {
//    this.pageNum = start;
//    this.pageSize = pageSize;
//    this.curPage = curPage;
//    this.total = totalSize;
//    this.list = list;
//  }
//
//  public int getCurPage() {
//    return curPage;
//  }
//
//  public void setCurPage(int curPage) {
//    this.curPage = curPage;
//  }
//
//  public int getPageNum() {
//    return pageNum;
//  }
//
//  public void setPageNum(int pageNum) {
//    this.pageNum = pageNum;
//  }
//
//  public int getPageSize() {
//    return pageSize;
//  }
//
//  public void setPageSize(int pageSize) {
//    this.pageSize = pageSize;
//  }
//
//  public long getTotal() {
//    return total;
//  }
//
//  public void setTotal(long total) {
//    this.total = total;
//  }
//
//  public int getPages() {
//    return pages;
//  }
//
//  public void setPages(int pages) {
//    this.pages = pages;
//  }
//
//  public List<T> getList() {
//    return list;
//  }
//
//  public void setList(List<T> list) {
//    this.list = list;
//  }
//}
