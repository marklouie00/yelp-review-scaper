package com.scraper.utils;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;

import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;

import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import com.scraper.dto.AvatarEmotion;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleVisionApiLabelUtils {

	private static final Logger LOG = LoggerFactory.getLogger(GoogleVisionApiLabelUtils.class);

	public static AvatarEmotion detectFaces(String filePath) throws IOException {

		AvatarEmotion avatarEmotion = new AvatarEmotion();
		List<AnnotateImageRequest> requests = new ArrayList<>();
		URL url = new URL(filePath);
		BufferedImage image = ImageIO.read(url);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", bos);
		byte[] data = bos.toByteArray();

		ByteString imgBytes = ByteString.copyFrom(data);

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					LOG.warn("Error: %s\n", res.getError().getMessage());
					break;
				}

				FaceAnnotation annotation = res.getFaceAnnotationsList().get(0);
				String joy = annotation.getJoyLikelihood().toString();
				String surprise = annotation.getSurpriseLikelihood().toString();
				String anger = annotation.getAngerLikelihood().toString();
				String sorrow = annotation.getSorrowLikelihood().toString();
				avatarEmotion = new AvatarEmotion(joy, surprise, anger, sorrow);

			}
		}
		return avatarEmotion;
	}

}
