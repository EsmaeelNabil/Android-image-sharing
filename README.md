# Android-image-sharing
download an image from a url and share it to any app that - uses Glide, Asyntask, Gif.


#### using Glide

    implementation 'com.github.bumptech.glide:glide:4.9.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
    
    #### just use this class.
    
        Share share = new Share(
        this   // Activity 
        ,this  // Context
        ,photoUrl // Url link
        ,R.layout.loader_custom_layout  // custom loader layout
        ,R.id.imageView    // loader imageView 
        ,R.drawable.tenor  // gif drawable for the loader
        );
