package jaeger.de.miel.HelloThymeleaf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.binaryheart.common.comparator.AlphaNumericComparator;
import jaeger.de.miel.HelloThymeleaf.dto.ContentItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CuriosityTest {

    private String DTO = "{\n" +
            "  \"name\" : \"tibcouniversalinstaller-lnx-x86-64_3.6.6_v19.bin\",\n" +
            "  \"size\" : \"102 MB\",\n" +
            "  \"sizeInBytes\" : 107987968,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 3, 20 ],\n" +
            "  \"url\" : \"https://ansible.ing.net/curios/P03881-TibcoBWGlobalpurpose/tibcouniversalinstaller-lnx-x86-64_3.6.6_v19.bin\"\n" +
            "}";


    private String DTOs = "[ {\n" +
            "  \"name\" : \"Hello.txt\",\n" +
            "  \"size\" : \"5 bytes\",\n" +
            "  \"sizeInBytes\" : 5,\n" +
            "  \"last_modified\" : [ 2022, 3, 7, 15, 42, 26 ]\n" +
            "}, {\n" +
            "  \"name\" : \"TIB_hawk_5.2.0_HF-007_win_x86_64.zip\",\n" +
            "  \"size\" : \"102 MB\",\n" +
            "  \"sizeInBytes\" : 107588874,\n" +
            "  \"last_modified\" : [ 2022, 7, 19, 9, 15, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"TIB_hawk_5.2.0_win_x86_64.zip\",\n" +
            "  \"size\" : \"221 MB\",\n" +
            "  \"sizeInBytes\" : 232657032,\n" +
            "  \"last_modified\" : [ 2022, 6, 16, 8, 0, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible-role-bw-storage.1.0.1.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5629,\n" +
            "  \"last_modified\" : [ 2021, 9, 15, 12, 57, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible-role-bw-storage.1.0.2.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5604,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 10, 1, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible-role-bw-storage.1.0.3.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5413,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 10, 27, 10 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible-role-oracle-java.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7475,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 11, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_oracle_java.0.1.1.tar.gz\",\n" +
            "  \"size\" : \"8 KB\",\n" +
            "  \"sizeInBytes\" : 8859,\n" +
            "  \"last_modified\" : [ 2021, 11, 24, 10, 40, 17 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.10.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3359,\n" +
            "  \"last_modified\" : [ 2021, 10, 4, 11, 16, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.100.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5853,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 16, 27, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.101.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5866,\n" +
            "  \"last_modified\" : [ 2022, 12, 6, 10, 31, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.102.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5854,\n" +
            "  \"last_modified\" : [ 2022, 12, 7, 8, 29, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.103.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5853,\n" +
            "  \"last_modified\" : [ 2022, 12, 16, 10, 22, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.104.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5854,\n" +
            "  \"last_modified\" : [ 2022, 12, 16, 13, 56, 24 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.105.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5860,\n" +
            "  \"last_modified\" : [ 2022, 12, 21, 9, 0, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.106.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5853,\n" +
            "  \"last_modified\" : [ 2022, 12, 22, 20, 25, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.107.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5852,\n" +
            "  \"last_modified\" : [ 2023, 1, 16, 9, 36, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.11.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3341,\n" +
            "  \"last_modified\" : [ 2021, 10, 4, 11, 32, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.12.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3346,\n" +
            "  \"last_modified\" : [ 2021, 10, 4, 11, 43, 23 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.13.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3345,\n" +
            "  \"last_modified\" : [ 2021, 10, 5, 11, 39, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.14.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3443,\n" +
            "  \"last_modified\" : [ 2021, 10, 7, 13, 27, 25 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.15.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3442,\n" +
            "  \"last_modified\" : [ 2021, 10, 8, 9, 20, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.16.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3445,\n" +
            "  \"last_modified\" : [ 2021, 10, 8, 12, 19, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.17.tar.gz\",\n" +
            "  \"size\" : \"4 KB\",\n" +
            "  \"sizeInBytes\" : 4171,\n" +
            "  \"last_modified\" : [ 2021, 10, 26, 7, 33, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.18.tar.gz\",\n" +
            "  \"size\" : \"4 KB\",\n" +
            "  \"sizeInBytes\" : 4178,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 9, 4, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.19.tar.gz\",\n" +
            "  \"size\" : \"4 KB\",\n" +
            "  \"sizeInBytes\" : 4179,\n" +
            "  \"last_modified\" : [ 2021, 11, 5, 14, 41, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.20.tar.gz\",\n" +
            "  \"size\" : \"4 KB\",\n" +
            "  \"sizeInBytes\" : 4175,\n" +
            "  \"last_modified\" : [ 2021, 11, 8, 12, 30, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.21.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3966,\n" +
            "  \"last_modified\" : [ 2021, 11, 18, 9, 42, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.22.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3972,\n" +
            "  \"last_modified\" : [ 2021, 11, 24, 11, 16, 13 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.23.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3966,\n" +
            "  \"last_modified\" : [ 2021, 11, 25, 7, 42, 58 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.24.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3972,\n" +
            "  \"last_modified\" : [ 2021, 11, 25, 11, 8, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.25.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3974,\n" +
            "  \"last_modified\" : [ 2021, 12, 2, 15, 42, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.26.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3973,\n" +
            "  \"last_modified\" : [ 2021, 12, 3, 11, 13, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.27.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3962,\n" +
            "  \"last_modified\" : [ 2021, 12, 7, 14, 22, 23 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.28.tar.gz\",\n" +
            "  \"size\" : \"4 KB\",\n" +
            "  \"sizeInBytes\" : 4263,\n" +
            "  \"last_modified\" : [ 2022, 1, 25, 15, 4, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.29.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3901,\n" +
            "  \"last_modified\" : [ 2022, 1, 31, 10, 33, 39 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.30.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3904,\n" +
            "  \"last_modified\" : [ 2022, 2, 1, 11, 11, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.31.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3895,\n" +
            "  \"last_modified\" : [ 2022, 2, 2, 9, 34, 4 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.32.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4010,\n" +
            "  \"last_modified\" : [ 2022, 2, 8, 15, 25, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.33.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4009,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 9, 5, 26 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.34.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4006,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 9, 57, 29 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.35.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4008,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 13, 20, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.36.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4009,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 15, 27, 10 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.37.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4010,\n" +
            "  \"last_modified\" : [ 2022, 2, 10, 17, 53, 37 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.38.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4012,\n" +
            "  \"last_modified\" : [ 2022, 2, 11, 10, 44, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.39.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4008,\n" +
            "  \"last_modified\" : [ 2022, 2, 11, 14, 42, 49 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.40.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4010,\n" +
            "  \"last_modified\" : [ 2022, 2, 16, 12, 53, 6 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.41.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4008,\n" +
            "  \"last_modified\" : [ 2022, 2, 17, 16, 2, 5 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.42.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4010,\n" +
            "  \"last_modified\" : [ 2022, 2, 18, 9, 17, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.43.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4007,\n" +
            "  \"last_modified\" : [ 2022, 2, 21, 11, 32, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.44.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4008,\n" +
            "  \"last_modified\" : [ 2022, 2, 22, 11, 57, 25 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.45.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4009,\n" +
            "  \"last_modified\" : [ 2022, 2, 23, 13, 55, 58 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.46.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4010,\n" +
            "  \"last_modified\" : [ 2022, 2, 23, 14, 41, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.47.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4025,\n" +
            "  \"last_modified\" : [ 2022, 2, 28, 15, 17, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.48.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4021,\n" +
            "  \"last_modified\" : [ 2022, 3, 1, 14, 37, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.49.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4025,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 7, 38, 5 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.5.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3229,\n" +
            "  \"last_modified\" : [ 2021, 9, 13, 14, 6, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.50.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4032,\n" +
            "  \"last_modified\" : [ 2022, 3, 21, 14, 56, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.51.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4034,\n" +
            "  \"last_modified\" : [ 2022, 3, 22, 8, 49, 39 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.52.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4035,\n" +
            "  \"last_modified\" : [ 2022, 3, 22, 15, 13, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.53.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4028,\n" +
            "  \"last_modified\" : [ 2022, 3, 23, 10, 5, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.54.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4032,\n" +
            "  \"last_modified\" : [ 2022, 3, 30, 15, 46, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.55.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4027,\n" +
            "  \"last_modified\" : [ 2022, 4, 4, 8, 39, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.56.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4038,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 6, 31, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.57.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3980,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 10, 27, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.58.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3978,\n" +
            "  \"last_modified\" : [ 2022, 5, 3, 6, 52, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.59.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3974,\n" +
            "  \"last_modified\" : [ 2022, 5, 4, 6, 58, 25 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.60.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3983,\n" +
            "  \"last_modified\" : [ 2022, 5, 18, 10, 51, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.61.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3984,\n" +
            "  \"last_modified\" : [ 2022, 5, 20, 14, 54, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.62.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3983,\n" +
            "  \"last_modified\" : [ 2022, 5, 23, 13, 38, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.63.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3979,\n" +
            "  \"last_modified\" : [ 2022, 5, 30, 8, 0, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.64.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3979,\n" +
            "  \"last_modified\" : [ 2022, 6, 28, 13, 56, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.65.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3975,\n" +
            "  \"last_modified\" : [ 2022, 6, 29, 14, 28, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.66.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3973,\n" +
            "  \"last_modified\" : [ 2022, 6, 29, 15, 16, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.67.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3982,\n" +
            "  \"last_modified\" : [ 2022, 7, 6, 9, 59, 19 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.68.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3972,\n" +
            "  \"last_modified\" : [ 2022, 7, 6, 12, 14, 28 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.69.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3983,\n" +
            "  \"last_modified\" : [ 2022, 7, 7, 10, 8, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.7.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3353,\n" +
            "  \"last_modified\" : [ 2021, 9, 27, 8, 52, 29 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.70.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3998,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 15, 7, 58 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.71.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3999,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 16, 22, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.72.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3983,\n" +
            "  \"last_modified\" : [ 2022, 7, 20, 12, 56, 42 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.73.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3976,\n" +
            "  \"last_modified\" : [ 2022, 7, 20, 14, 8, 31 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.74.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4004,\n" +
            "  \"last_modified\" : [ 2022, 7, 28, 11, 31, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.75.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4001,\n" +
            "  \"last_modified\" : [ 2022, 7, 28, 11, 43, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.76.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4000,\n" +
            "  \"last_modified\" : [ 2022, 8, 5, 9, 32, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.77.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4038,\n" +
            "  \"last_modified\" : [ 2022, 8, 8, 10, 50, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.78.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4033,\n" +
            "  \"last_modified\" : [ 2022, 8, 8, 12, 10, 25 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.79.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4029,\n" +
            "  \"last_modified\" : [ 2022, 8, 15, 10, 53, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.8.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3412,\n" +
            "  \"last_modified\" : [ 2021, 9, 29, 8, 53, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.80.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3985,\n" +
            "  \"last_modified\" : [ 2022, 8, 16, 13, 56, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.81.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3984,\n" +
            "  \"last_modified\" : [ 2022, 8, 17, 14, 13, 36 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.82.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3978,\n" +
            "  \"last_modified\" : [ 2022, 8, 22, 11, 5, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.83.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3977,\n" +
            "  \"last_modified\" : [ 2022, 8, 30, 7, 53, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.84.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3976,\n" +
            "  \"last_modified\" : [ 2022, 9, 1, 9, 52, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.85.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3980,\n" +
            "  \"last_modified\" : [ 2022, 9, 3, 16, 44, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.86.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3982,\n" +
            "  \"last_modified\" : [ 2022, 9, 5, 14, 54, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.87.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3984,\n" +
            "  \"last_modified\" : [ 2022, 9, 6, 7, 36, 40 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.88.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3986,\n" +
            "  \"last_modified\" : [ 2022, 9, 6, 9, 59, 49 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.89.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3978,\n" +
            "  \"last_modified\" : [ 2022, 9, 7, 11, 11, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.9.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3345,\n" +
            "  \"last_modified\" : [ 2021, 9, 30, 11, 56, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.90.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3984,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 15, 25, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.91.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3977,\n" +
            "  \"last_modified\" : [ 2022, 9, 13, 7, 6, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.92.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3980,\n" +
            "  \"last_modified\" : [ 2022, 10, 10, 11, 2, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.93.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3976,\n" +
            "  \"last_modified\" : [ 2022, 10, 10, 12, 53, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.94.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3981,\n" +
            "  \"last_modified\" : [ 2022, 10, 10, 13, 24, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.95.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 3977,\n" +
            "  \"last_modified\" : [ 2022, 10, 11, 9, 39, 31 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.96.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5869,\n" +
            "  \"last_modified\" : [ 2022, 11, 15, 17, 14, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.97.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5870,\n" +
            "  \"last_modified\" : [ 2022, 11, 16, 13, 6, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.98.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5866,\n" +
            "  \"last_modified\" : [ 2022, 11, 17, 11, 15, 17 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_playbook_tibco_bw_pattern_one_repo.1.0.99.tar.gz\",\n" +
            "  \"size\" : \"5 KB\",\n" +
            "  \"sizeInBytes\" : 5869,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 11, 52, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_hello.0.1.1.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 3009,\n" +
            "  \"last_modified\" : [ 2022, 3, 2, 14, 38, 6 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_hello.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 3034,\n" +
            "  \"last_modified\" : [ 2022, 3, 2, 15, 17, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_hello.0.1.3.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2987,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 11, 59, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.10.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160254,\n" +
            "  \"last_modified\" : [ 2021, 11, 18, 9, 41, 42 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.11.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160254,\n" +
            "  \"last_modified\" : [ 2021, 11, 24, 10, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.12.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160237,\n" +
            "  \"last_modified\" : [ 2021, 11, 25, 7, 43, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.13.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160252,\n" +
            "  \"last_modified\" : [ 2021, 11, 25, 11, 9, 4 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.14.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160272,\n" +
            "  \"last_modified\" : [ 2021, 12, 2, 15, 31, 24 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.15.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160532,\n" +
            "  \"last_modified\" : [ 2022, 2, 1, 10, 56, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.16.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160565,\n" +
            "  \"last_modified\" : [ 2022, 2, 28, 10, 33, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.17.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160636,\n" +
            "  \"last_modified\" : [ 2022, 3, 21, 14, 28, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.18.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160694,\n" +
            "  \"last_modified\" : [ 2022, 4, 12, 13, 23, 39 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.19.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160652,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 11, 59, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.20.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160636,\n" +
            "  \"last_modified\" : [ 2022, 5, 17, 9, 0, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.21.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160583,\n" +
            "  \"last_modified\" : [ 2022, 5, 20, 14, 42, 13 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.22.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160944,\n" +
            "  \"last_modified\" : [ 2022, 7, 6, 9, 47, 49 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.24.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160956,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 9, 16, 54 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.25.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4169309,\n" +
            "  \"last_modified\" : [ 2022, 8, 16, 13, 38, 4 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26-use-purpose-code-story-1181954.11.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4161119,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 13, 40, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26-use-purpose-code-story-1181954.12.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4161120,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 13, 51, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26-use-purpose-code-story-1181954.13.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4161105,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 16, 18, 8 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26-use-purpose-code-story-1181954.17.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4169473,\n" +
            "  \"last_modified\" : [ 2022, 8, 8, 6, 51, 54 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26-use-purpose-code-story-1181954.7.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4161238,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 9, 4, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.26.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4169319,\n" +
            "  \"last_modified\" : [ 2022, 8, 31, 9, 41, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.27.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4169319,\n" +
            "  \"last_modified\" : [ 2022, 9, 6, 7, 29, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.28.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4169318,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 15, 12, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.29.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4171749,\n" +
            "  \"last_modified\" : [ 2022, 11, 15, 12, 37, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.30.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4171667,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 10, 43, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.31.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4171960,\n" +
            "  \"last_modified\" : [ 2022, 12, 21, 8, 51, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.32.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4171947,\n" +
            "  \"last_modified\" : [ 2023, 1, 16, 8, 50, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.4.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4159914,\n" +
            "  \"last_modified\" : [ 2021, 9, 13, 11, 37, 18 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.5.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4159900,\n" +
            "  \"last_modified\" : [ 2021, 10, 8, 9, 2, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.6.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160401,\n" +
            "  \"last_modified\" : [ 2021, 10, 25, 12, 8, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.7.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160488,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 8, 7, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.8.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160283,\n" +
            "  \"last_modified\" : [ 2021, 11, 5, 14, 13, 11 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin.1.0.9.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4160437,\n" +
            "  \"last_modified\" : [ 2021, 11, 10, 11, 22, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.1.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7339,\n" +
            "  \"last_modified\" : [ 2022, 1, 28, 12, 50, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.10.tar.gz\",\n" +
            "  \"size\" : \"150 KB\",\n" +
            "  \"sizeInBytes\" : 154497,\n" +
            "  \"last_modified\" : [ 2022, 8, 22, 10, 48, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7382,\n" +
            "  \"last_modified\" : [ 2022, 1, 28, 14, 38, 36 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.3.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7434,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 13, 1, 58 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.4.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7435,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 15, 21, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.5.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7728,\n" +
            "  \"last_modified\" : [ 2022, 2, 17, 15, 55, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.6.tar.gz\",\n" +
            "  \"size\" : \"7 KB\",\n" +
            "  \"sizeInBytes\" : 7873,\n" +
            "  \"last_modified\" : [ 2022, 2, 21, 11, 22, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.7.tar.gz\",\n" +
            "  \"size\" : \"8 KB\",\n" +
            "  \"sizeInBytes\" : 8193,\n" +
            "  \"last_modified\" : [ 2022, 2, 22, 11, 51, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.8-get-soll-id-via-sollar.11.tar.gz\",\n" +
            "  \"size\" : \"96 KB\",\n" +
            "  \"sizeInBytes\" : 99326,\n" +
            "  \"last_modified\" : [ 2022, 7, 28, 11, 19, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.8-get-soll-id-via-sollar.13.tar.gz\",\n" +
            "  \"size\" : \"97 KB\",\n" +
            "  \"sizeInBytes\" : 99626,\n" +
            "  \"last_modified\" : [ 2022, 8, 5, 9, 22, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.8-get-soll-id-via-sollar.14.tar.gz\",\n" +
            "  \"size\" : \"97 KB\",\n" +
            "  \"sizeInBytes\" : 99530,\n" +
            "  \"last_modified\" : [ 2022, 8, 15, 9, 35, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.8.tar.gz\",\n" +
            "  \"size\" : \"151 KB\",\n" +
            "  \"sizeInBytes\" : 154955,\n" +
            "  \"last_modified\" : [ 2022, 8, 16, 13, 39, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_admin_update_acl.0.1.9.tar.gz\",\n" +
            "  \"size\" : \"150 KB\",\n" +
            "  \"sizeInBytes\" : 154460,\n" +
            "  \"last_modified\" : [ 2022, 8, 17, 14, 4, 33 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.0.2.5-curiosity.3.tar.gz\",\n" +
            "  \"size\" : \"11 KB\",\n" +
            "  \"sizeInBytes\" : 12130,\n" +
            "  \"last_modified\" : [ 2021, 9, 7, 14, 6, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.10.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14669,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 7, 52, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.11.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14475,\n" +
            "  \"last_modified\" : [ 2021, 11, 5, 14, 14, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.12.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14806,\n" +
            "  \"last_modified\" : [ 2021, 11, 10, 11, 22, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.13.tar.gz\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 14282,\n" +
            "  \"last_modified\" : [ 2021, 11, 18, 9, 42, 28 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.14.tar.gz\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 14278,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 15, 2, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.15.tar.gz\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 14289,\n" +
            "  \"last_modified\" : [ 2021, 12, 2, 15, 31, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.16.tar.gz\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 14292,\n" +
            "  \"last_modified\" : [ 2021, 12, 3, 10, 55, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.17.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14502,\n" +
            "  \"last_modified\" : [ 2022, 2, 8, 15, 16, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.18.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14725,\n" +
            "  \"last_modified\" : [ 2022, 2, 8, 18, 49, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.19.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14692,\n" +
            "  \"last_modified\" : [ 2022, 2, 9, 9, 43, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.20.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14718,\n" +
            "  \"last_modified\" : [ 2022, 2, 10, 17, 46, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.21.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14740,\n" +
            "  \"last_modified\" : [ 2022, 2, 11, 10, 35, 39 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.22.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14946,\n" +
            "  \"last_modified\" : [ 2022, 2, 23, 13, 48, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.23.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14978,\n" +
            "  \"last_modified\" : [ 2022, 2, 28, 10, 35, 42 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.24.tar.gz\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 15257,\n" +
            "  \"last_modified\" : [ 2022, 3, 11, 6, 48, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.25.tar.gz\",\n" +
            "  \"size\" : \"15 KB\",\n" +
            "  \"sizeInBytes\" : 16112,\n" +
            "  \"last_modified\" : [ 2022, 3, 21, 14, 29, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.26.tar.gz\",\n" +
            "  \"size\" : \"15 KB\",\n" +
            "  \"sizeInBytes\" : 16104,\n" +
            "  \"last_modified\" : [ 2022, 3, 22, 14, 59, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.27.tar.gz\",\n" +
            "  \"size\" : \"16 KB\",\n" +
            "  \"sizeInBytes\" : 16615,\n" +
            "  \"last_modified\" : [ 2022, 3, 30, 14, 35, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.28.tar.gz\",\n" +
            "  \"size\" : \"16 KB\",\n" +
            "  \"sizeInBytes\" : 17056,\n" +
            "  \"last_modified\" : [ 2022, 4, 12, 13, 49, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.29.tar.gz\",\n" +
            "  \"size\" : \"16 KB\",\n" +
            "  \"sizeInBytes\" : 17007,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 11, 59, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.30.tar.gz\",\n" +
            "  \"size\" : \"39 KB\",\n" +
            "  \"sizeInBytes\" : 40434,\n" +
            "  \"last_modified\" : [ 2022, 4, 26, 7, 5, 17 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.31.tar.gz\",\n" +
            "  \"size\" : \"39 KB\",\n" +
            "  \"sizeInBytes\" : 40423,\n" +
            "  \"last_modified\" : [ 2022, 5, 17, 9, 1, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.32.tar.gz\",\n" +
            "  \"size\" : \"41 KB\",\n" +
            "  \"sizeInBytes\" : 42218,\n" +
            "  \"last_modified\" : [ 2022, 5, 20, 14, 42, 8 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.33.tar.gz\",\n" +
            "  \"size\" : \"41 KB\",\n" +
            "  \"sizeInBytes\" : 42217,\n" +
            "  \"last_modified\" : [ 2022, 5, 23, 13, 32, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.34.tar.gz\",\n" +
            "  \"size\" : \"41 KB\",\n" +
            "  \"sizeInBytes\" : 42268,\n" +
            "  \"last_modified\" : [ 2022, 6, 28, 13, 43, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.35.tar.gz\",\n" +
            "  \"size\" : \"41 KB\",\n" +
            "  \"sizeInBytes\" : 42329,\n" +
            "  \"last_modified\" : [ 2022, 6, 29, 14, 19, 11 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.36.tar.gz\",\n" +
            "  \"size\" : \"46 KB\",\n" +
            "  \"sizeInBytes\" : 47917,\n" +
            "  \"last_modified\" : [ 2022, 7, 6, 9, 47, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.37.tar.gz\",\n" +
            "  \"size\" : \"46 KB\",\n" +
            "  \"sizeInBytes\" : 47956,\n" +
            "  \"last_modified\" : [ 2022, 7, 7, 9, 58, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.38.tar.gz\",\n" +
            "  \"size\" : \"47 KB\",\n" +
            "  \"sizeInBytes\" : 48500,\n" +
            "  \"last_modified\" : [ 2022, 7, 20, 12, 44, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.39.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50242,\n" +
            "  \"last_modified\" : [ 2022, 8, 31, 12, 16, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.4.tar.gz\",\n" +
            "  \"size\" : \"11 KB\",\n" +
            "  \"sizeInBytes\" : 12129,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 12, 55, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.40.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50241,\n" +
            "  \"last_modified\" : [ 2022, 9, 5, 14, 49, 40 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.41.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50243,\n" +
            "  \"last_modified\" : [ 2022, 9, 6, 9, 44, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.42.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50247,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 15, 12, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.43.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50305,\n" +
            "  \"last_modified\" : [ 2022, 10, 7, 13, 53, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.44.tar.gz\",\n" +
            "  \"size\" : \"49 KB\",\n" +
            "  \"sizeInBytes\" : 50313,\n" +
            "  \"last_modified\" : [ 2022, 10, 10, 13, 13, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.45.tar.gz\",\n" +
            "  \"size\" : \"52 KB\",\n" +
            "  \"sizeInBytes\" : 54201,\n" +
            "  \"last_modified\" : [ 2022, 11, 15, 12, 38, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.46.tar.gz\",\n" +
            "  \"size\" : \"52 KB\",\n" +
            "  \"sizeInBytes\" : 54251,\n" +
            "  \"last_modified\" : [ 2022, 11, 16, 12, 24, 18 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.47.tar.gz\",\n" +
            "  \"size\" : \"52 KB\",\n" +
            "  \"sizeInBytes\" : 54256,\n" +
            "  \"last_modified\" : [ 2022, 11, 17, 11, 10, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.48.tar.gz\",\n" +
            "  \"size\" : \"53 KB\",\n" +
            "  \"sizeInBytes\" : 54801,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 10, 43, 37 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.5.tar.gz\",\n" +
            "  \"size\" : \"11 KB\",\n" +
            "  \"sizeInBytes\" : 12184,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 13, 31, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.6.tar.gz\",\n" +
            "  \"size\" : \"11 KB\",\n" +
            "  \"sizeInBytes\" : 12182,\n" +
            "  \"last_modified\" : [ 2021, 9, 9, 8, 33, 58 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.7.tar.gz\",\n" +
            "  \"size\" : \"12 KB\",\n" +
            "  \"sizeInBytes\" : 13051,\n" +
            "  \"last_modified\" : [ 2021, 9, 13, 9, 54, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.8.tar.gz\",\n" +
            "  \"size\" : \"12 KB\",\n" +
            "  \"sizeInBytes\" : 13058,\n" +
            "  \"last_modified\" : [ 2021, 9, 13, 10, 25, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_inplace_update.1.0.9.tar.gz\",\n" +
            "  \"size\" : \"12 KB\",\n" +
            "  \"sizeInBytes\" : 13301,\n" +
            "  \"last_modified\" : [ 2021, 10, 25, 12, 8, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_process_exporter_config.0.1.0.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4047,\n" +
            "  \"last_modified\" : [ 2022, 10, 21, 9, 26, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_process_exporter_config.0.1.1.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4039,\n" +
            "  \"last_modified\" : [ 2022, 10, 21, 13, 20, 13 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_process_exporter_config.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"3 KB\",\n" +
            "  \"sizeInBytes\" : 4039,\n" +
            "  \"last_modified\" : [ 2022, 10, 21, 14, 6, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.10.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4137121,\n" +
            "  \"last_modified\" : [ 2021, 11, 10, 11, 21, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.11.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136935,\n" +
            "  \"last_modified\" : [ 2021, 11, 18, 9, 42, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.12.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136915,\n" +
            "  \"last_modified\" : [ 2021, 11, 24, 10, 48, 17 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.13.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136915,\n" +
            "  \"last_modified\" : [ 2021, 11, 25, 7, 42, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.14.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136922,\n" +
            "  \"last_modified\" : [ 2021, 12, 2, 15, 28, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.15.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136928,\n" +
            "  \"last_modified\" : [ 2022, 2, 1, 10, 57, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.16.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136927,\n" +
            "  \"last_modified\" : [ 2022, 2, 23, 13, 30, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.17.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4143252,\n" +
            "  \"last_modified\" : [ 2022, 2, 28, 10, 30, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.18.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4143587,\n" +
            "  \"last_modified\" : [ 2022, 3, 21, 14, 29, 10 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.19.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4143592,\n" +
            "  \"last_modified\" : [ 2022, 3, 22, 8, 32, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.20.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144461,\n" +
            "  \"last_modified\" : [ 2022, 4, 12, 13, 22, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.21.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144389,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 11, 59, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.22.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144392,\n" +
            "  \"last_modified\" : [ 2022, 4, 20, 6, 59, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.23.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144380,\n" +
            "  \"last_modified\" : [ 2022, 5, 17, 9, 1, 37 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.24.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144423,\n" +
            "  \"last_modified\" : [ 2022, 5, 20, 14, 42, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.25.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144417,\n" +
            "  \"last_modified\" : [ 2022, 5, 23, 9, 5, 52 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.26.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144482,\n" +
            "  \"last_modified\" : [ 2022, 7, 6, 9, 47, 49 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.27.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144477,\n" +
            "  \"last_modified\" : [ 2022, 8, 31, 9, 8, 6 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.28.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144488,\n" +
            "  \"last_modified\" : [ 2022, 9, 6, 9, 45, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.29.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4144487,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 15, 13, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.30.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4147474,\n" +
            "  \"last_modified\" : [ 2022, 11, 15, 12, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.31.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4147385,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 10, 46, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.32.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4147380,\n" +
            "  \"last_modified\" : [ 2022, 12, 16, 10, 9, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.5.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136252,\n" +
            "  \"last_modified\" : [ 2021, 9, 13, 11, 59, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.6.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4136212,\n" +
            "  \"last_modified\" : [ 2021, 10, 8, 12, 10, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.7.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4137052,\n" +
            "  \"last_modified\" : [ 2021, 10, 25, 12, 12, 23 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.8.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4137297,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 7, 51, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ansible_role_tibco_runtime.1.0.9.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4137078,\n" +
            "  \"last_modified\" : [ 2021, 11, 5, 14, 13, 37 ]\n" +
            "}, {\n" +
            "  \"name\" : \"apphosting-java-playbook.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"8 KB\",\n" +
            "  \"sizeInBytes\" : 8701,\n" +
            "  \"last_modified\" : [ 2021, 11, 19, 13, 49, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"apphosting-java-playbook.0.1.3.tar.gz\",\n" +
            "  \"size\" : \"8 KB\",\n" +
            "  \"sizeInBytes\" : 8702,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 9, 29, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"apphosting-java-playbook.0.1.4.tar.gz\",\n" +
            "  \"size\" : \"8 KB\",\n" +
            "  \"sizeInBytes\" : 8709,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 14, 4, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"assembly_tibco_com_tibco_tpcl_org_hibernate_feature_3.2.500.002.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 34, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"ext_jars-1.0.0.zip\",\n" +
            "  \"size\" : \"4 MB\",\n" +
            "  \"sizeInBytes\" : 4275889,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 13, 25, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"goss-0.3.5-1.el6.x86_64.rpm\",\n" +
            "  \"size\" : \"2 MB\",\n" +
            "  \"sizeInBytes\" : 2543384,\n" +
            "  \"last_modified\" : [ 2021, 12, 9, 12, 35, 53 ]\n" +
            "}, {\n" +
            "  \"name\" : \"goss-0.3.5-1.el7.x86_64.rpm\",\n" +
            "  \"size\" : \"2 MB\",\n" +
            "  \"sizeInBytes\" : 2516688,\n" +
            "  \"last_modified\" : [ 2021, 12, 9, 12, 36, 19 ]\n" +
            "}, {\n" +
            "  \"name\" : \"hawkconfig-5.2.0.war\",\n" +
            "  \"size\" : \"538 KB\",\n" +
            "  \"sizeInBytes\" : 551621,\n" +
            "  \"last_modified\" : [ 2022, 4, 21, 13, 44, 54 ]\n" +
            "}, {\n" +
            "  \"name\" : \"hawkconsole-5.2.0.war\",\n" +
            "  \"size\" : \"1 MB\",\n" +
            "  \"sizeInBytes\" : 1693037,\n" +
            "  \"last_modified\" : [ 2022, 4, 21, 13, 45, 11 ]\n" +
            "}, {\n" +
            "  \"name\" : \"hello.txt\",\n" +
            "  \"size\" : \"15 bytes\",\n" +
            "  \"sizeInBytes\" : 15,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 23, 29 ]\n" +
            "}, {\n" +
            "  \"name\" : \"instantclient-basiclite-linux.x64-21.3.0.0.0.zip\",\n" +
            "  \"size\" : \"36 MB\",\n" +
            "  \"sizeInBytes\" : 38659827,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 2, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"instantclient-sqlplus-linux.x64-21.3.0.0.0.zip\",\n" +
            "  \"size\" : \"914 KB\",\n" +
            "  \"sizeInBytes\" : 936305,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 2, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"monitoring-console-5.2.0.war\",\n" +
            "  \"size\" : \"1 MB\",\n" +
            "  \"sizeInBytes\" : 1470587,\n" +
            "  \"last_modified\" : [ 2022, 4, 21, 13, 45, 23 ]\n" +
            "}, {\n" +
            "  \"name\" : \"node_exporter-1.3.1\",\n" +
            "  \"size\" : \"17 MB\",\n" +
            "  \"sizeInBytes\" : 18228926,\n" +
            "  \"last_modified\" : [ 2022, 9, 27, 12, 37, 37 ]\n" +
            "}, {\n" +
            "  \"name\" : \"oracle-instantclient12.2-basic-12.2.0.1.0-1.x86_64.rpm\",\n" +
            "  \"size\" : \"50 MB\",\n" +
            "  \"sizeInBytes\" : 52826628,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 1, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"oracle-instantclient12.2-sqlplus-12.2.0.1.0-1.x86_64.rpm\",\n" +
            "  \"size\" : \"691 KB\",\n" +
            "  \"sizeInBytes\" : 708104,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 2, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"process-exporter-0.7.10\",\n" +
            "  \"size\" : \"9 MB\",\n" +
            "  \"sizeInBytes\" : 9977856,\n" +
            "  \"last_modified\" : [ 2022, 9, 27, 12, 37, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_eclipse_lgpl_rcp_4.4.2.001_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 34, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.060_linux_x86_64.zip\",\n" +
            "  \"size\" : \"95 KB\",\n" +
            "  \"sizeInBytes\" : 97766,\n" +
            "  \"last_modified\" : [ 2022, 11, 28, 12, 1, 13 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.192_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 34, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.281_win_x86_64.zip\",\n" +
            "  \"size\" : \"59 KB\",\n" +
            "  \"sizeInBytes\" : 60999,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 42, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.301_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109904,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 53, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.311_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109902,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 15, 3, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.321_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109924,\n" +
            "  \"last_modified\" : [ 2022, 3, 4, 9, 17, 5 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.333-b.1_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109923,\n" +
            "  \"last_modified\" : [ 2022, 5, 18, 11, 31, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.333_linux_x86_64.zip\",\n" +
            "  \"size\" : \"111 KB\",\n" +
            "  \"sizeInBytes\" : 113854,\n" +
            "  \"last_modified\" : [ 2022, 5, 10, 8, 53, 39 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.333_win_x86_64.zip\",\n" +
            "  \"size\" : \"61 KB\",\n" +
            "  \"sizeInBytes\" : 63371,\n" +
            "  \"last_modified\" : [ 2022, 5, 12, 11, 11, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.341_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109917,\n" +
            "  \"last_modified\" : [ 2022, 8, 23, 9, 47, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.341_win_x86_64.zip\",\n" +
            "  \"size\" : \"62 KB\",\n" +
            "  \"sizeInBytes\" : 64348,\n" +
            "  \"last_modified\" : [ 2022, 10, 11, 10, 17, 38 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.351_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109918,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 8, 17, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.361_linux_x86_64.zip\",\n" +
            "  \"size\" : \"107 KB\",\n" +
            "  \"sizeInBytes\" : 109919,\n" +
            "  \"last_modified\" : [ 2023, 1, 24, 12, 53, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"product_tibco_sunec_1.8.0.361_win_x86_64.zip\",\n" +
            "  \"size\" : \"62 KB\",\n" +
            "  \"sizeInBytes\" : 64378,\n" +
            "  \"last_modified\" : [ 2023, 1, 25, 12, 46, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.1.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1045,\n" +
            "  \"last_modified\" : [ 2021, 9, 9, 11, 37, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.2.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2173,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 14, 14, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.3.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2181,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 14, 22, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.4.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2169,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 14, 38, 24 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.5.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2194,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 14, 52, 41 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.6.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2251,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 14, 57, 31 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.7.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2253,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 15, 2, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2-test.8.tar.gz\",\n" +
            "  \"size\" : \"2 KB\",\n" +
            "  \"sizeInBytes\" : 2348,\n" +
            "  \"last_modified\" : [ 2021, 10, 28, 15, 14, 4 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity-azdo.0.2.2.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1904,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 8, 52, 10 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity.0.1.2.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1046,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 10, 57, 24 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity.0.1.3.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1045,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 11, 29, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity.0.1.4.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1046,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 11, 47, 36 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity.0.1.5.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1046,\n" +
            "  \"last_modified\" : [ 2021, 9, 8, 12, 21, 18 ]\n" +
            "}, {\n" +
            "  \"name\" : \"test-with-curiosity.0.1.6.tar.gz\",\n" +
            "  \"size\" : \"1 KB\",\n" +
            "  \"sizeInBytes\" : 1045,\n" +
            "  \"last_modified\" : [ 2021, 9, 9, 7, 57, 9 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_amx-bpm_4.3.0_hf-001.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 35, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_amx-bpm_4.3.1_linux24gl23_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 34, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_amx_3.4.0_hf-002_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 36, 26 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_amx_3.4.0_hf-003_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 36, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_amx_3.4.0_hf-004_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 35, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_business-studio-bpm-edition_4.3.1_win_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 35, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.0_hf-011.zip\",\n" +
            "  \"size\" : \"5 MB\",\n" +
            "  \"sizeInBytes\" : 5919209,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 58, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.0_hf-013.zip\",\n" +
            "  \"size\" : \"6 MB\",\n" +
            "  \"sizeInBytes\" : 6704144,\n" +
            "  \"last_modified\" : [ 2021, 12, 1, 13, 12, 36 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"193 MB\",\n" +
            "  \"sizeInBytes\" : 203083962,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 58, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.0_win_x86_64.zip\",\n" +
            "  \"size\" : \"191 MB\",\n" +
            "  \"sizeInBytes\" : 200796547,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 42, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.1_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"196 MB\",\n" +
            "  \"sizeInBytes\" : 205817626,\n" +
            "  \"last_modified\" : [ 2022, 6, 29, 7, 39, 19 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.14.1_win_x86_64.zip\",\n" +
            "  \"size\" : \"192 MB\",\n" +
            "  \"sizeInBytes\" : 201784760,\n" +
            "  \"last_modified\" : [ 2022, 7, 8, 12, 40, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bw_5.15.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"200 MB\",\n" +
            "  \"sizeInBytes\" : 209945539,\n" +
            "  \"last_modified\" : [ 2022, 11, 9, 13, 18, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwplugincopybook_3.5.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"74 MB\",\n" +
            "  \"sizeInBytes\" : 77962901,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 59, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwplugincopybook_3.6.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"112 MB\",\n" +
            "  \"sizeInBytes\" : 117945694,\n" +
            "  \"last_modified\" : [ 2022, 4, 13, 10, 48, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwplugincopybook_3.6.0_win_x86_64.zip\",\n" +
            "  \"size\" : \"75 MB\",\n" +
            "  \"sizeInBytes\" : 78761065,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 44, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginmq_7.7.3_hf-001.zip\",\n" +
            "  \"size\" : \"1 MB\",\n" +
            "  \"sizeInBytes\" : 1210743,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 59, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginmq_7.7.3_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"114 MB\",\n" +
            "  \"sizeInBytes\" : 120297187,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 59, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginmq_7.8.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"114 MB\",\n" +
            "  \"sizeInBytes\" : 120580554,\n" +
            "  \"last_modified\" : [ 2022, 11, 16, 9, 53, 42 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginrestjson_2.1.0_hf-009.zip\",\n" +
            "  \"size\" : \"6 MB\",\n" +
            "  \"sizeInBytes\" : 7234676,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 59, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginrestjson_2.1.0_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"92 MB\",\n" +
            "  \"sizeInBytes\" : 97487774,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 0, 22 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_bwpluginrestjson_2.1.0_win_x86_64.zip\",\n" +
            "  \"size\" : \"93 MB\",\n" +
            "  \"sizeInBytes\" : 98285817,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 44, 36 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_10.2.0_rpm_bundle_linux_x86_64.zip\",\n" +
            "  \"size\" : \"17 MB\",\n" +
            "  \"sizeInBytes\" : 18301303,\n" +
            "  \"last_modified\" : [ 2022, 11, 9, 13, 35, 29 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.5.1_hf-003.zip\",\n" +
            "  \"size\" : \"1 MB\",\n" +
            "  \"sizeInBytes\" : 1050530,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 1, 2 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.5.1_linux_x86_64.zip\",\n" +
            "  \"size\" : \"116 MB\",\n" +
            "  \"sizeInBytes\" : 122416374,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 0, 48 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.5.1_win_x86_64.exe\",\n" +
            "  \"size\" : \"61 MB\",\n" +
            "  \"sizeInBytes\" : 64208592,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 45, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.6.0_hf-004_linux_x86_64.zip\",\n" +
            "  \"size\" : \"6 MB\",\n" +
            "  \"sizeInBytes\" : 6341413,\n" +
            "  \"last_modified\" : [ 2022, 12, 12, 9, 32, 1 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.6.0_linux_x86_64.zip\",\n" +
            "  \"size\" : \"114 MB\",\n" +
            "  \"sizeInBytes\" : 120389647,\n" +
            "  \"last_modified\" : [ 2022, 2, 2, 14, 17, 32 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.6.0_rpm_bundle_linux_x86_64.zip\",\n" +
            "  \"size\" : \"54 MB\",\n" +
            "  \"sizeInBytes\" : 57389635,\n" +
            "  \"last_modified\" : [ 2022, 11, 4, 12, 9, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_ems_8.6.0_win_x86_64.exe\",\n" +
            "  \"size\" : \"60 MB\",\n" +
            "  \"sizeInBytes\" : 63276552,\n" +
            "  \"last_modified\" : [ 2022, 4, 8, 12, 36, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_hawk_5.2.0_hf-008_linux26gl23_x86_64.zip\",\n" +
            "  \"size\" : \"103 MB\",\n" +
            "  \"sizeInBytes\" : 108237277,\n" +
            "  \"last_modified\" : [ 2022, 11, 28, 12, 1, 31 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.4.6_linux_x86.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 33, 57 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.5.1_linux_x86_64.rpm\",\n" +
            "  \"size\" : \"15 MB\",\n" +
            "  \"sizeInBytes\" : 16765816,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 5, 33 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.5.1_win_x86_64.exe\",\n" +
            "  \"size\" : \"15 MB\",\n" +
            "  \"sizeInBytes\" : 15938328,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 45, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.5.2_win_x86_64.exe\",\n" +
            "  \"size\" : \"15 MB\",\n" +
            "  \"sizeInBytes\" : 16063920,\n" +
            "  \"last_modified\" : [ 2022, 4, 8, 12, 36, 31 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.6.0_linux_x86_64.rpm\",\n" +
            "  \"size\" : \"21 MB\",\n" +
            "  \"sizeInBytes\" : 22584408,\n" +
            "  \"last_modified\" : [ 2022, 11, 9, 13, 35, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.6.0_win_x86_64.exe\",\n" +
            "  \"size\" : \"15 MB\",\n" +
            "  \"sizeInBytes\" : 16525928,\n" +
            "  \"last_modified\" : [ 2023, 1, 19, 13, 13, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_rv_8.6.1_linux_x86_64.rpm\",\n" +
            "  \"size\" : \"24 MB\",\n" +
            "  \"sizeInBytes\" : 25956488,\n" +
            "  \"last_modified\" : [ 2023, 1, 18, 10, 43, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tibcoadmin_5.11.2_linux_x86_64.zip\",\n" +
            "  \"size\" : \"134 MB\",\n" +
            "  \"sizeInBytes\" : 140748512,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 11, 57, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tibcoadmin_5.11.3_linux_x86_64.zip\",\n" +
            "  \"size\" : \"135 MB\",\n" +
            "  \"sizeInBytes\" : 141667250,\n" +
            "  \"last_modified\" : [ 2022, 6, 9, 9, 1, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tibcoadmin_5.12.0_linux_x86_64.zip\",\n" +
            "  \"size\" : \"137 MB\",\n" +
            "  \"sizeInBytes\" : 143951465,\n" +
            "  \"last_modified\" : [ 2022, 11, 9, 13, 36, 21 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u331-b.1_win_x86_64.zip\",\n" +
            "  \"size\" : \"380 MB\",\n" +
            "  \"sizeInBytes\" : 399106835,\n" +
            "  \"last_modified\" : [ 2022, 5, 12, 13, 56, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u331_win_x86_64.zip\",\n" +
            "  \"size\" : \"757 MB\",\n" +
            "  \"sizeInBytes\" : 793825475,\n" +
            "  \"last_modified\" : [ 2022, 5, 12, 8, 3, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333-b.1_win_x86_64.tar.gz\",\n" +
            "  \"size\" : \"378 MB\",\n" +
            "  \"sizeInBytes\" : 397406910,\n" +
            "  \"last_modified\" : [ 2022, 5, 18, 14, 47, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333-b.1_win_x86_64.zip\",\n" +
            "  \"size\" : \"380 MB\",\n" +
            "  \"sizeInBytes\" : 399106835,\n" +
            "  \"last_modified\" : [ 2022, 5, 12, 14, 8, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333-b.2_win_x86_64.zip\",\n" +
            "  \"size\" : \"380 MB\",\n" +
            "  \"sizeInBytes\" : 398984965,\n" +
            "  \"last_modified\" : [ 2022, 5, 16, 9, 25, 42 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333-b.3_win_x86_64.zip\",\n" +
            "  \"size\" : \"380 MB\",\n" +
            "  \"sizeInBytes\" : 399106835,\n" +
            "  \"last_modified\" : [ 2022, 5, 16, 11, 19, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333-b.4_win_x86_64.zip\",\n" +
            "  \"size\" : \"304 MB\",\n" +
            "  \"sizeInBytes\" : 319285469,\n" +
            "  \"last_modified\" : [ 2022, 5, 19, 11, 19, 28 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_jre8u333_win_x86_64.zip\",\n" +
            "  \"size\" : \"757 MB\",\n" +
            "  \"sizeInBytes\" : 793947345,\n" +
            "  \"last_modified\" : [ 2022, 5, 12, 10, 5, 7 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64.zip\",\n" +
            "  \"size\" : \"80 bytes\",\n" +
            "  \"sizeInBytes\" : 80,\n" +
            "  \"last_modified\" : [ 2021, 12, 21, 12, 38, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u301.zip\",\n" +
            "  \"size\" : \"317 MB\",\n" +
            "  \"sizeInBytes\" : 332556872,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 5, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u311.zip\",\n" +
            "  \"size\" : \"324 MB\",\n" +
            "  \"sizeInBytes\" : 339794494,\n" +
            "  \"last_modified\" : [ 2021, 11, 22, 15, 3, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u321.zip\",\n" +
            "  \"size\" : \"324 MB\",\n" +
            "  \"sizeInBytes\" : 339814885,\n" +
            "  \"last_modified\" : [ 2022, 3, 1, 12, 39, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u333-b.1.zip\",\n" +
            "  \"size\" : \"325 MB\",\n" +
            "  \"sizeInBytes\" : 341002377,\n" +
            "  \"last_modified\" : [ 2022, 5, 19, 12, 6, 35 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u333.zip\",\n" +
            "  \"size\" : \"406 MB\",\n" +
            "  \"sizeInBytes\" : 426252970,\n" +
            "  \"last_modified\" : [ 2022, 5, 10, 8, 54, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_linux_x86_64_jre8u341.zip\",\n" +
            "  \"size\" : \"348 MB\",\n" +
            "  \"sizeInBytes\" : 365682112,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 9, 16, 43 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.2_win_x86_64.zip\",\n" +
            "  \"size\" : \"301 MB\",\n" +
            "  \"sizeInBytes\" : 315872222,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 43, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_jre8u333_win_x86_64.zip\",\n" +
            "  \"size\" : \"305 MB\",\n" +
            "  \"sizeInBytes\" : 319935807,\n" +
            "  \"last_modified\" : [ 2022, 7, 12, 10, 26, 45 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_jre8u341-1_win_x86_64.zip\",\n" +
            "  \"size\" : \"301 MB\",\n" +
            "  \"sizeInBytes\" : 315855260,\n" +
            "  \"last_modified\" : [ 2022, 10, 11, 14, 36, 16 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_jre8u341_win_x86_64.zip\",\n" +
            "  \"size\" : \"218 MB\",\n" +
            "  \"sizeInBytes\" : 229297896,\n" +
            "  \"last_modified\" : [ 2022, 10, 7, 11, 26, 34 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_jre8u361_win_x86_64.zip\",\n" +
            "  \"size\" : \"302 MB\",\n" +
            "  \"sizeInBytes\" : 317629349,\n" +
            "  \"last_modified\" : [ 2023, 1, 24, 14, 0 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8u333.zip\",\n" +
            "  \"size\" : \"348 MB\",\n" +
            "  \"sizeInBytes\" : 365542217,\n" +
            "  \"last_modified\" : [ 2022, 6, 8, 11, 2, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8u341-2.zip\",\n" +
            "  \"size\" : \"348 MB\",\n" +
            "  \"sizeInBytes\" : 365682112,\n" +
            "  \"last_modified\" : [ 2022, 9, 12, 14, 31, 51 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8u341.zip\",\n" +
            "  \"size\" : \"348 MB\",\n" +
            "  \"sizeInBytes\" : 365542219,\n" +
            "  \"last_modified\" : [ 2022, 8, 23, 9, 47, 30 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8u351.zip\",\n" +
            "  \"size\" : \"350 MB\",\n" +
            "  \"sizeInBytes\" : 367159782,\n" +
            "  \"last_modified\" : [ 2022, 12, 5, 8, 17, 12 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8u361.zip\",\n" +
            "  \"size\" : \"350 MB\",\n" +
            "  \"sizeInBytes\" : 367771638,\n" +
            "  \"last_modified\" : [ 2023, 1, 24, 12, 53, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_linux_x86_64_jre8ujre8u333.zip\",\n" +
            "  \"size\" : \"348 MB\",\n" +
            "  \"sizeInBytes\" : 365542248,\n" +
            "  \"last_modified\" : [ 2022, 6, 8, 10, 23, 27 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.11.3_win_x86_64.zip\",\n" +
            "  \"size\" : \"303 MB\",\n" +
            "  \"sizeInBytes\" : 318713728,\n" +
            "  \"last_modified\" : [ 2022, 7, 11, 11, 39, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_tra_5.12.1_linux_x86_64.zip\",\n" +
            "  \"size\" : \"400 MB\",\n" +
            "  \"sizeInBytes\" : 420363370,\n" +
            "  \"last_modified\" : [ 2022, 11, 9, 13, 36, 59 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tib_universal-installer_3.7.4_v1_hf-001_win_x86_64.exe\",\n" +
            "  \"size\" : \"98 MB\",\n" +
            "  \"sizeInBytes\" : 103307256,\n" +
            "  \"last_modified\" : [ 2022, 3, 14, 12, 46, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco-artifactory-to-curiosity.0.2.0-alpha.40.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4159790,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 15, 21, 3 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco-artifactory-to-curiosity.0.2.0-alpha.41.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4159757,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 15, 34, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco-artifactory-to-curiosity.0.2.0-alpha.tar.gz\",\n" +
            "  \"size\" : \"3 MB\",\n" +
            "  \"sizeInBytes\" : 4159762,\n" +
            "  \"last_modified\" : [ 2021, 11, 1, 15, 39, 6 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.10.0.zip\",\n" +
            "  \"size\" : \"9 KB\",\n" +
            "  \"sizeInBytes\" : 9686,\n" +
            "  \"last_modified\" : [ 2022, 5, 16, 13, 31, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.15.0.zip\",\n" +
            "  \"size\" : \"12 KB\",\n" +
            "  \"sizeInBytes\" : 13122,\n" +
            "  \"last_modified\" : [ 2022, 6, 20, 12, 45, 54 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.23.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14643,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 7, 38, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.24.0.zip\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 13409,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 8, 28, 24 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.25.0.zip\",\n" +
            "  \"size\" : \"13 KB\",\n" +
            "  \"sizeInBytes\" : 13401,\n" +
            "  \"last_modified\" : [ 2022, 7, 14, 10, 20, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.26.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14687,\n" +
            "  \"last_modified\" : [ 2022, 7, 19, 13, 49, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.29.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14687,\n" +
            "  \"last_modified\" : [ 2022, 10, 11, 10, 33, 44 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.30.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14687,\n" +
            "  \"last_modified\" : [ 2022, 10, 17, 10, 37, 55 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.31.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14687,\n" +
            "  \"last_modified\" : [ 2023, 1, 19, 13, 58, 23 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.33.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14683,\n" +
            "  \"last_modified\" : [ 2023, 1, 20, 7, 22, 50 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.34.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14683,\n" +
            "  \"last_modified\" : [ 2023, 1, 20, 8, 38, 47 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.35.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14683,\n" +
            "  \"last_modified\" : [ 2023, 1, 26, 10, 35, 56 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.36.0.zip\",\n" +
            "  \"size\" : \"14 KB\",\n" +
            "  \"sizeInBytes\" : 14683,\n" +
            "  \"last_modified\" : [ 2023, 1, 26, 12, 43, 49 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.6.0.zip\",\n" +
            "  \"size\" : \"69 KB\",\n" +
            "  \"sizeInBytes\" : 71184,\n" +
            "  \"last_modified\" : [ 2022, 4, 15, 13, 13, 46 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package.0.7.0.zip\",\n" +
            "  \"size\" : \"69 KB\",\n" +
            "  \"sizeInBytes\" : 71184,\n" +
            "  \"last_modified\" : [ 2022, 5, 16, 13, 26, 14 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package_ipc.0.13.0.zip\",\n" +
            "  \"size\" : \"71 KB\",\n" +
            "  \"sizeInBytes\" : 73095,\n" +
            "  \"last_modified\" : [ 2022, 3, 16, 12, 20, 5 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibco_bw_designer_package_ipc.0.14.0.zip\",\n" +
            "  \"size\" : \"11 KB\",\n" +
            "  \"sizeInBytes\" : 11732,\n" +
            "  \"last_modified\" : [ 2022, 3, 16, 12, 28, 20 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibcobw-rtk2-1.0.0.zip\",\n" +
            "  \"size\" : \"4 MB\",\n" +
            "  \"sizeInBytes\" : 4778786,\n" +
            "  \"last_modified\" : [ 2022, 10, 24, 14, 23, 15 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibcobw-rtk2-1.0.1.zip\",\n" +
            "  \"size\" : \"4 MB\",\n" +
            "  \"sizeInBytes\" : 4778785,\n" +
            "  \"last_modified\" : [ 2022, 10, 26, 9, 14, 28 ]\n" +
            "}, {\n" +
            "  \"name\" : \"tibcouniversalinstaller-lnx-x86-64_3.6.6_v19.bin\",\n" +
            "  \"size\" : \"102 MB\",\n" +
            "  \"sizeInBytes\" : 107987968,\n" +
            "  \"last_modified\" : [ 2021, 11, 4, 12, 3, 20 ]\n" +
            "} ]";

    @Test
    public void test() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        ContentItemDTO contentItemDTO = objectMapper.readValue(DTO, ContentItemDTO.class);
//        System.out.println(contentItemDTO);


        CollectionType objectMapperClass = objectMapper.getTypeFactory().constructCollectionType(List.class, ContentItemDTO.class);
        List<ContentItemDTO> contentItemDTOs = objectMapper.readValue(DTOs, objectMapperClass);

//        contentItemDTOs.forEach(dto -> System.out.println(dto.getName()));
//                System.out.println(contentItemDTOs);


//        Comparator<ContentItemDTO> comparator = Comparator.comparing(ContentItemDTO::getName);

        AlphaNumericComparator comparator = new AlphaNumericComparator();
        Comparator<ContentItemDTO> compareAsc = (dto1, dto2) -> comparator.compare(dto1.getName(), dto2.getName());
        Comparator<ContentItemDTO> compareDesc = (dto1, dto2) -> comparator.compare(dto2.getName(), dto1.getName());

        contentItemDTOs.sort(compareAsc);
//        System.out.println(contentItemDTOs);
        contentItemDTOs.forEach(dto -> System.out.println(dto.getName()));




//        List<ContentItemDTO> result = contentItemDTOs.stream()
//                .sorted((dto1, dto2) -> comparator.compare(dto1.getName(), dto2.getName()))
//
//                .collect(Collectors.toList());
//        System.out.println(result);
    }


}
