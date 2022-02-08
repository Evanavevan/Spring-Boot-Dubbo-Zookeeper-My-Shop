package com.evan.myshop.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.service.user.api.TbUserService;
import com.evan.myshop.statics.backend.dto.DataTableDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class TbUserController {

    @Reference(version = "${services.versions.user.v1}")
    private TbUserService tbUserService;

    /**
     * 查询全部
     * @param model {@link Model}
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user/list";
    }

    /**
     * 分页查询
     * @param request {@link HttpServletRequest}
     * @param tbUser {@link TbUser}
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public DataTableDTO<TbUser> page(HttpServletRequest request, TbUser tbUser) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);

        PageInfo<TbUser> pageInfo = tbUserService.page(start, length);
        DataTableDTO<TbUser> dataTableDTO = new DataTableDTO<>();
        dataTableDTO.setDraw(draw);
        dataTableDTO.setData(pageInfo.getList());
        dataTableDTO.setRecordsTotal(pageInfo.getTotal());
        dataTableDTO.setRecordsFilter(pageInfo.getTotal());

        return dataTableDTO;
    }

}
