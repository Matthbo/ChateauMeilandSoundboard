package app.matthbo.chateau_meiland_soundboard;


import java.util.Arrays;
import java.util.Comparator;

public class SoundManager {

    private static SoundClip[] soundClips = new SoundClip[0];

    /**
     * Loads sounds into soundClips
     */
    public static void loadSounds(){

        //TODO retrieve soundsclips from API (if necessary);

        soundClips = new SoundClip[]{
                new SoundClip(R.raw.a_droite, "A droite"),
                new SoundClip(R.raw.a_gauche, "A gauche"),
                new SoundClip(R.raw.ach_doe_niet_zo_stom, "Ach doe niet zo stom"),
                new SoundClip(R.raw.ach_vervelend_weer, "Ach vervelend weer"),
                new SoundClip(R.raw.ach_waarom_bel_jij_me_nou, "Ach waarom bel jij me nou"),
                new SoundClip(R.raw.ach_wat_is_dit_nou_weer, "Ach wat is dit nou weer"),
                new SoundClip(R.raw.au_revoir, "Au revoir"),
                new SoundClip(R.raw.auw_niet_zo_hard, "Auw niet zo hard"),
                new SoundClip(R.raw.ben_er_zo_klaar_mee, "Ben er zo klaar mee"),
                new SoundClip(R.raw.ben_zo_blij_dat_het_meevalt, "Ben zo blij dat het meevalt"),
                new SoundClip(R.raw.bonjour, "Bonjour"),
                new SoundClip(R.raw.boodschappen, "Boodschappen"),
                new SoundClip(R.raw.brocante, "Brocante"),
                new SoundClip(R.raw.demain_a_huit_heure, "Demain a huit heure"),
                new SoundClip(R.raw.die_mensen_wachten_echt_wel_even, "Die mensen wachten echt wel even"),
                new SoundClip(R.raw.doe_niet_zo_vervelend, "Doe niet zo vervelend"),
                new SoundClip(R.raw.draaien_draaien, "Draaien draaien"),
                new SoundClip(R.raw.eerste_stroomversnelling, "1e stroomversnelling"),
                new SoundClip(R.raw.electricite, "Electricité"),
                new SoundClip(R.raw.ferme, "Fermé"),
                new SoundClip(R.raw.gips, "Gips"),
                new SoundClip(R.raw.gipsplaten, "Gipsplaten"),
                new SoundClip(R.raw.godver_wat_een_geouwehoer, "Godver wat een geouwehoer"),
                new SoundClip(R.raw.half_12, "Half 12"),
                new SoundClip(R.raw.help_mama_even, "Help mama even"),
                new SoundClip(R.raw.het_muurtje, "Het muurtje"),
                new SoundClip(R.raw.ik_kom, "Ik kom"),
                new SoundClip(R.raw.ik_moet_door, "Ik moet door"),
                new SoundClip(R.raw.ik_zeg_wil_je_wat_drinken, "Ik zeg wil je wat drinken"),
                new SoundClip(R.raw.ja_enig, "Ja enig"),
                new SoundClip(R.raw.kijk_uit_joh, "Kijk uit joh"),
                new SoundClip(R.raw.klap, "KLAP"),
                new SoundClip(R.raw.kruiwagens_met_grind, "Kruiwagens met grind"),
                new SoundClip(R.raw.kut, "Kut"),
                new SoundClip(R.raw.laatste_vrije_middag, "Laatste vrije middag"),
                new SoundClip(R.raw.lepra_hand, "Lepra hand"),
                new SoundClip(R.raw.ligt_tie_thuis, "Ligt tie thuis"),
                new SoundClip(R.raw.lijstjes, "Lijstjes"),
                new SoundClip(R.raw.moet_je_wat_drinken, "Moet je wat drinken"),
                new SoundClip(R.raw.moet_jij_nog_brood_bestellen, "Moet jij nog brood bestellen"),
                new SoundClip(R.raw.net_doen_of_je_gek_bent, "Net doen of je gek bent"),
                new SoundClip(R.raw.net_doen_of_je_gek_bent_2, "Net doen of je gek bent 2"),
                new SoundClip(R.raw.niet_druk_maken, "Niet druk maken"),
                new SoundClip(R.raw.niet_naar_de_snelweg, "Niet naar de snelweg"),
                new SoundClip(R.raw.niet_zeuren_dat_je_straks_moe_bent, "Niet zeuren dat je straks moe bent"),
                new SoundClip(R.raw.niet_zo_hard, "Niet zo hard"),
                new SoundClip(R.raw.niet_zo_hard_slaan, "Niet zo hard slaan"),
                new SoundClip(R.raw.niet_zo_hard_straks_heb_je_weer_een_bon, "Niet zo hard, straks heb je weer een bon"),
                new SoundClip(R.raw.nou_dat_weer, "Nou dat weer"),
                new SoundClip(R.raw.nu_even_niet, "Nu even niet"),
                new SoundClip(R.raw.nu_kan_het_niet_meer, "Nu kan het niet meer"),
                new SoundClip(R.raw.oh_je_telefoon, "Oh, je telefoon"),
                new SoundClip(R.raw.oh_kut, "Oh kut"),
                new SoundClip(R.raw.pas_de_contract, "Pas de contract"),
                new SoundClip(R.raw.rouge_geverfd, "Rouge geverfd"),
                new SoundClip(R.raw.say_na_na_na, "Say na na na"),
                new SoundClip(R.raw.schoonmaken_dweilen_en_klaar, "Schoonmaken, dweilen en klaar"),
                new SoundClip(R.raw.schouw, "Schouw"),
                new SoundClip(R.raw.spul_voor_de_kruiwagen, "Spul voor de kruiwagen"),
                new SoundClip(R.raw.tweede_stroomversnelling, "2e stroomversnelling"),
                new SoundClip(R.raw.versnelde_water, "Versnelde water"),
                new SoundClip(R.raw.votre_nom, "Votre nom"),
                new SoundClip(R.raw.waarom_zou_ik_rijden, "Waarom zou ik rijden"),
                new SoundClip(R.raw.wat_een_gezeik, "Wat een gezeik"),
                new SoundClip(R.raw.wat_goeed, "Wat goeed"),
                new SoundClip(R.raw.wat_is_het_allemaal_chaotisch, "Wat is het allemaal chaotisch"),
                new SoundClip(R.raw.wat_rij_jij_raar, "Wat rij jij raar"),
                new SoundClip(R.raw.weet_ik_niet, "Weet ik niet"),
                new SoundClip(R.raw.wie_had_er_gebeld, "Wie had er gebeld"),
                new SoundClip(R.raw.wijnen_wijnen_wijnen, "Wijnen wijnen wijnen"),
                new SoundClip(R.raw.zeker_over_de_datum, "Zeker over de datum"),
                new SoundClip(R.raw.zullen_we_na_na_na_doen, "Zullen we na na na doen"),
        };

        Arrays.sort(soundClips, new Comparator<SoundClip>() {
            @Override
            public int compare(SoundClip sound1, SoundClip sound2) {
                return sound1.name.compareTo(sound2.name);
            }
        });
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
