package com.ms_security.ms_security.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ms_security.ms_security.utilities.ErrorControlUtilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class CloudinaryImpl {
    private final Cloudinary _cloudinary;
    private final ErrorControlUtilities _errorControlUtilities;

    public String uploadFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return _errorControlUtilities.handleErrorAsString(null, 33L);
        Map uploadResult = _cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("secure_url").toString();
    }
}
