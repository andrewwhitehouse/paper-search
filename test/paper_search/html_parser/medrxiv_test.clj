(ns paper-search.html-parser.medrxiv-test
  (:require [clojure.test :refer :all]
            [paper-search.html-parser.medrxiv :refer :all]
            [net.cgrand.enlive-html :refer :all]
            [clojure.java.io :as io]))

(deftest parses-example-page
  (let [parsed (parse (-> "medrxiv_example.html" io/resource slurp))]
    (testing "parses page"
      (is (= {:description      "Abstract Background The coronavirus disease 2019 (COVID-19) pandemic presents significant safety challenges to healthcare professionals. In some jurisdictions, over 10% of confirmed cases of COVID-19 have been found among healthcare workers. Aerosol-generating medical procedures (AGMPs) may increase the risk of nosocomial transmission, exacerbated by present global shortages of personal protective equipment (PPE). Improved methods for mitigating risk during AGMPs are therefore urgently needed. Methods The Aerosol Containment Enclosure (ACE) was constructed from acrylic with silicone gaskets for arm port seals and completed with a thin plastic sheet. Hospital wall suction generated negative pressure within the ACE. To evaluate protective capability, differential pressures were recorded under static conditions and during simulated AGMPs. Smoke flow patterns, fluorescence aerosolization, and sodium saccharin aerosolization tests were also conducted. Results Negative pressures of up to −47.7 mmH2O were obtained using the enclosure with two wall suction units (combined outflow of 70 L min−1), with inflow of O2 of 15 L min−1. Negative pressures between −10 and −35 mmH2O were maintained during simulated AGMPs, including oxygen delivery by mask, airway suctioning, bag-mask manual ventilation and endotracheal intubation of a potential COVID-19 patient. The ACE effectively contained smoke, fluorescein aerosol, and sodium saccharin aerosol within the enclosure during use. Conclusions The ACE is capable of maintaining negative pressure during simulated AGMPs. In all cases, containment was improved relative to an identical enclosure with non-occluded ports at ambient pressure. During the current COVID-19 pandemic, the use of such a device may assist in reducing nosocomial infections among healthcare providers.  ### Competing Interest Statement  The authors have declared no competing interest.  ### Funding Statement  The authors acknowledge the Natural Sciences and Engineering Council (NSERC) of Canada for financial support. ZMH is grateful for support from the Canada Research Chairs program.  ### Author Declarations  All relevant ethical guidelines have been followed; any necessary IRB and/or ethics committee approvals have been obtained and details of the IRB/oversight body are included in the manuscript.  Yes  All necessary patient/participant consent has been obtained and the appropriate institutional forms have been archived.  Yes  I understand that all clinical trials and any other prospective interventional studies must be registered with an ICMJE-approved registry, such as ClinicalTrials.gov. I confirm that any such study reported in the manuscript has been registered and the trial registration ID is provided (note: if posting a prospective study registered retrospectively, please provide a statement in the trial ID field explaining why the study was not registered in advance).  Yes  I have followed all appropriate research reporting guidelines and uploaded the relevant EQUATOR Network research reporting checklist(s) and other pertinent material as supplementary files, if applicable.  Yes  All data collected is presented in the manuscript or supplementary index.",
              :abstract-url     "https://www.medrxiv.org/content/10.1101/2020.04.14.20063958v2.abstract",
              :author-email     "anthony.chahal@gmail.com",
              :publisher        "Cold Spring Harbor Laboratory Press",
              :pdf-link         "https://www.medrxiv.org/content/medrxiv/early/2020/04/21/2020.04.14.20063958.full.pdf",
              :abstract         "<p>Abstract Background The coronavirus disease 2019 (COVID-19) pandemic presents significant safety challenges to healthcare professionals. In some jurisdictions, over 10% of confirmed cases of COVID-19 have been found among healthcare workers. Aerosol-generating medical procedures (AGMPs) may increase the risk of nosocomial transmission, exacerbated by present global shortages of personal protective equipment (PPE). Improved methods for mitigating risk during AGMPs are therefore urgently needed. Methods The Aerosol Containment Enclosure (ACE) was constructed from acrylic with silicone gaskets for arm port seals and completed with a thin plastic sheet. Hospital wall suction generated negative pressure within the ACE. To evaluate protective capability, differential pressures were recorded under static conditions and during simulated AGMPs. Smoke flow patterns, fluorescence aerosolization, and sodium saccharin aerosolization tests were also conducted.   Results Negative pressures of up to −47.7 mmH<sub>2</sub>O were obtained using the enclosure with two wall suction units (combined outflow of 70 L min<sup>−1</sup>), with inflow of O<sub>2</sub> of 15 L min<sup>−1</sup>. Negative pressures between −10 and −35 mmH<sub>2</sub>O were maintained during simulated AGMPs, including oxygen delivery by mask, airway suctioning, bag-mask manual ventilation and endotracheal intubation of a potential COVID-19 patient. The ACE effectively contained smoke, fluorescein aerosol, and sodium saccharin aerosol within the enclosure during use.  Conclusions The ACE is capable of maintaining negative pressure during simulated AGMPs. In all cases, containment was improved relative to an identical enclosure with non-occluded ports at ambient pressure.  During the current COVID-19 pandemic, the use of such a device may assist in reducing nosocomial infections among healthcare providers.</p>",
              :doi              "10.1101/2020.04.14.20063958",
              :title            "A Rapidly Deployable Negative Pressure Enclosure for Aerosol-Generating Medical Procedures",
              :author           "Zachary M. Hudson",
              :publication-date "2020/01/01",
              :rights           "© 2020, Posted by Cold Spring Harbor Laboratory. This pre-print is available under a Creative Commons License (Attribution-NonCommercial-NoDerivs 4.0 International), CC BY-NC-ND 4.0, as described at http://creativecommons.org/licenses/by-nc-nd/4.0/",
              :language         "en",
              :id               "2020.04.14.20063958v2",
              :html-url         "https://www.medrxiv.org/content/10.1101/2020.04.14.20063958v2.full",
              :journal-title    "medRxiv"}
             parsed)))))
