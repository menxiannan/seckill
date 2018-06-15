package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author MXN
 * @create 2018-05-21 17:23
 */
@Controller
/**
 *
 * url://模块/资源/{id}/细分
 * /seckill/list
 */
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    /**
     * 列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.getSeckillList(0, 100);
        model.addAttribute("list", list);
        //list.jsp + model = ModelAndView
        return "list";
    }

    /**
     * 详情
     *
     * @param seckillId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }


    @RequestMapping(value = "/saveSeckill", method = RequestMethod.GET)
    public String saveSeckill() {

        return "save";
    }


    //request.getRequestDispatcher("new.jsp").forward(request, response);//转发到new.jsp
    //response.sendRedirect("new.jsp");//重定向到new.jsp

    /**
     * 访问不到
     * @param seckill
     * @param name
     * @param number
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "/saveSeckill", method = RequestMethod.POST)
    public ModelAndView saveSeckill(Seckill seckill, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "number", required = false) Integer number,
                                    @RequestParam(value = "startTime", required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime) {


        if (seckill != null) {
            System.out.println(seckill.getName());
        }

        return new ModelAndView(redirect("/seckill/list"));
    }

    protected String redirect(String url) {

        return "redirect:" + url;
    }


    @ResponseBody
    @RequestMapping(value = "/saveSeckills", method = RequestMethod.POST)
    public SeckillResult<Exposer> saveSeckill(@RequestParam(value = "name") String name, @RequestParam(value = "number") Integer number,
                                              @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) {
        SeckillResult<Exposer> result;
        try {
            logger.warn("seckill={}", name);
            result = new SeckillResult<Exposer>(true, new Exposer(false, 1007));
        } catch (Exception e) {
            e.printStackTrace();
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    /**
     * ajax json
     * 输出秒杀地址
     *
     * @param seckillId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable(value = "seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    /**
     * 秒杀
     *
     * @param seckillId
     * @param md5
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable(value = "seckillId") Long seckillId,
                                                   @PathVariable(value = "md5") String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long phone) {

        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;

        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.PEPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillException e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult(true, now.getTime());
    }
}
