package com.example.usermanagementservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 4/7/2022, 4:06 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse<T> implements Serializable {
    private static final long serialVersionUID = 4640682579858733159L;
    private List<T> data;
    private int total = 0;
    private int page;
    private int totalPage;
    private int offset;
    private int limit;
    private boolean hasPrevious;
    private boolean hasNext;
    public PaginationResponse(int total, int offset, int limit, List<T> data) {
        this.total = total;
        this.offset = offset;
        this.limit = limit;
        this.page = calculateOffsetToPage(data);
        this.totalPage = calculateTotalPage();
        this.hasPrevious = calculateHasPrevious();
        this.hasNext = calculateHasNext();
        this.data = data;
    }
    public PaginationResponse(int page, int limit, int total) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.totalPage = calculateTotalPage();
        this.offset = calculateOffset();
        this.hasPrevious = calculateHasPrevious();
        this.hasNext = calculateHasNext();
    }
    private int calculateTotalPage() {
        return (int) Math.ceil((double)total / (double)limit);
    }
    private boolean calculateHasPrevious() {
        return page > 1;
    }
    private boolean calculateHasNext() {
        return totalPage > page;
    }
    private int calculateOffsetToPage(List<T> data) {
        return CollectionUtils.isEmpty(data) ? page : (offset / limit) + 1;
    }
    private int calculateOffset() {
        return ((page - 1) * limit);
    }
}
