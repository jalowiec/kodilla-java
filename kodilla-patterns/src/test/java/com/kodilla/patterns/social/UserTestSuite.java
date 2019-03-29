package com.kodilla.patterns.social;

import com.kodilla.patterns.strategy.social.*;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        Millenials marian = new Millenials("Marian");
        YGeneration yrek = new YGeneration("Yrek");
        ZGeneration zenek = new ZGeneration("Zenek");

        //When
        String millenialsPost = marian.sharePost();
        String yGenerationPost = yrek.sharePost();
        String zGenerationPost = zenek.sharePost();

        //Then
        Assert.assertEquals("Uzywam facebooka", millenialsPost);
        Assert.assertEquals("Uzywam Twittera", yGenerationPost);
        Assert.assertEquals("Uzywam snapchata", zGenerationPost);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        Millenials marian = new Millenials("Marian");
        YGeneration yrek = new YGeneration("Yrek");
        ZGeneration zenek = new ZGeneration("Zenek");

        //When
        marian.changeSocialMedium(new TwitterPublisher());
        String yGenerationPost = marian.sharePost();

        yrek.changeSocialMedium(new SnapchatPublisher());
        String zGenerationPost = yrek.sharePost();

        zenek.changeSocialMedium(new FacebookPublisher());
        String millenialsPost = zenek.sharePost();

        //Then
        Assert.assertEquals("Uzywam facebooka", millenialsPost);
        Assert.assertEquals("Uzywam Twittera", yGenerationPost);
        Assert.assertEquals("Uzywam snapchata", zGenerationPost);


    }
}
