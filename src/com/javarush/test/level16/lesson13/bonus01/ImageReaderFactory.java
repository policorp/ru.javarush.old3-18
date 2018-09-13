package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by mihanya on 10.08.2014.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes type) throws IllegalArgumentException{
        if (type == ImageTypes.BMP)
            return new BmpReader();
        if (type == ImageTypes.PNG)
            return new PngReader();
        if (type == ImageTypes.JPG)
            return new JpgReader();
        throw new IllegalArgumentException("Wrong format!");
    }
}
