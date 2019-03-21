package com.org.graduactionproject.contraller;

import com.org.graduactionproject.service.IPhotoService;
import com.org.graduactionproject.token.UserLoginToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class PhotoContraller {
    @Autowired
    IPhotoService photoService;


    /**
     *
     * @param req
     * @param file
     *          上传图片，将图片保存到uploaded文件夹下
     * @return
     */
    @RequestMapping(value = "/uploadPhoto")
    @ResponseBody
    @UserLoginToken
    public Map<String, Object> uploadPhoto(HttpServletRequest req, @RequestParam("file") MultipartFile file){
        Map<String,Object> map = new HashedMap();
        String filename = file.getName();
        file.getContentType();
        file.getOriginalFilename();
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
//            m.addAttribute("fileName", fileName);

            //7. 将访问路径放在map中，返回给vue
            map.put("url",  fileName);



            /**
             *  将路径，存储到数据库中
             */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message", "上传失败," + e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/deletePhotos")
    @ResponseBody
    @UserLoginToken
    public Map<String, Object> deletePhotos(HttpServletRequest req, @RequestBody String data){
        Map<String,Object> map = new HashedMap();
        String message = "";
        boolean warn = false;
        String path = req.getServletContext().getRealPath("") + "/uploaded/";
        JSONObject jsonObject = JSONObject.fromObject(data);
        JSONArray uploadList = jsonObject.getJSONArray("uploadList");
        for(int i=0; i < uploadList.size(); i++){
            JSONObject row = uploadList.getJSONObject(i);
            String url = row.getString("url");
            String sb = path + url;
            File file = new File(sb);
            if (file.exists()) {
                if (file.delete()) {
                    message =  "删除成功";
                } else {
                    message =  "退出删除图片时，文件："+ url + "删除失败\n";
                    warn = true;
                }
            } else {
                message = "退出删除图片时，文件：" + url +"不存在！\n";
                warn = true;
            }
        }
        map.put("warn",warn);
        map.put("message",message);
        return map;
    }
}
