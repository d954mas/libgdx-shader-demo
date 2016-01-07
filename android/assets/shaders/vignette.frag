#ifdef GL_ES
     #define LOWP lowp
     precision mediump float;
 #else
     #define LOWP
 #endif

 varying LOWP vec4 v_color;
 varying vec2 v_texCoords;
 uniform sampler2D u_texture;

 //our screen resolution, set from Java whenever the display is resized
 uniform vec2 resolution;
 uniform float radius;
 //softness of our vignette, between 0.0 and 1.0
 uniform float softness;
 //sepia colour, adjust to taste
 uniform vec3 sepia;
 uniform float mixStrength;

void main() {
        vec4 color = texture2D(u_texture, v_texCoords);

        //1. VIGNETTE
        //determine center
        vec2 position = (gl_FragCoord.xy / resolution.xy) - vec2(0.5);
        //OPTIONAL: correct for aspect ratio
        //correct aspect ratio
       // position.x *= resolution.x / resolution.y;
         //determine the vector length of the center position
         float len = length(position);
         //show our length for debugging
        // gl_FragColor = vec4( vec3(len), 1.0 );
        // gl_FragColor = vec4( color.rgb * (1.0 - len), 1.0 );
         //the radius of our circle
        // position.x *= resolution.x / resolution.y;
        // float r = 0.5;
        //the softness of our circle edge, between 0.0 and 1.0
      //  float softness = 0.05;
       // gl_FragColor = vec4( vec3( smoothstep(r-softness,r, len) ), 1.0 );


         //our vignette effect, using smoothstep
         //float vignette = smoothstep(radius, radius-softness, len);
         float vignette = smoothstep(radius, radius-softness, len);

         //apply our vignette
         //apply our vignette with mixStrength opacity mix is linear interpolation
         color.rgb = mix(color.rgb, color.rgb * vignette, mixStrength);

         gl_FragColor = color;
}


