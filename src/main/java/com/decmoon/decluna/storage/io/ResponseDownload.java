package com.decmoon.decluna.storage.io;

import com.decmoon.shortcut.exception.argument.ParameterIllegalException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author decmoon
 */
@Component
public class ResponseDownload {

    public void download(HttpServletResponse response, File file) {
        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
        ) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            byte[] buffer = new byte[1024];
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
            throw new ParameterIllegalException();
        }

    }
}
