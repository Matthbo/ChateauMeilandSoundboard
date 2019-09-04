package app.matthbo.chateau_meiland_soundboard;


public class SoundManager {

    private static SoundClip[] soundClips = new SoundClip[0];

    /**
     * Loads sounds into soundClips
     */
    public static void loadSounds(){

        //TODO retrieve soundsclips from API (if necessary);

        soundClips = new SoundClip[]{
                new SoundClip(R.raw.the_screaming_sheep, "Test 1"),
                new SoundClip(R.raw.hej_hej_hello_hello, "Test 2"),
                new SoundClip(R.raw.hej_hej_hello_hello, "lorum ipsum wdjfiudfiefhefhfiujfhoidojijovijhoihfowidoiwda dwuoihwdwdjwoid dwijiwod wiodjw"),
                new SoundClip(R.raw.hej_hej_hello_hello, "Martien op de kano"),
                new SoundClip(R.raw.hej_hej_hello_hello, "Martien is gevallen"),
                new SoundClip(R.raw.hej_hej_hello_hello, "Martien op de kano"),
        };
    }

    public static void unload(){
        soundClips = new SoundClip[0];
    }

    public static SoundClip[] getSoundClips(){
        return soundClips;
    }

    public static class SoundClip {
        private int resourceId;
        private String name;

        public SoundClip(int resourceId, String name){
            this.resourceId = resourceId;
            this.name = name;
        }

        public int getResourceId(){
            return this.resourceId;
        }

        public String getName(){
            return this.name;
        }
    }
}
