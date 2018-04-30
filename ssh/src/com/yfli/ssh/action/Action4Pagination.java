package com.yfli.ssh.action;

import com.yfli.ssh.util.Page;

public class Action4Pagination extends Action4Upload{
    protected Page page;
    public Page getPage() {
        return page;
    }
 
    public void setPage(Page page) {
        this.page = page;
    }
     
}