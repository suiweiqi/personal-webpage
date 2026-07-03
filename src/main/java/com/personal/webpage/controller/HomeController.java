package com.personal.webpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // --- 基本信息 ---
        model.addAttribute("name", "隋伟琦");
        model.addAttribute("title", "运维工程师");
        model.addAttribute("location", "中国 · 呼和浩特");
        model.addAttribute("email", "sui2628549643@163.com");
        model.addAttribute("github", "https://github.com/suiweiqi");
        model.addAttribute("currentYear", Year.now().getValue());

        // --- 关于我 ---
        model.addAttribute("aboutMe",
                "瞎写着玩的，没用，" +
                "对代码质量和用户体验没有一点追求。。。。" +
                "工作之余，我热衷玩LOL。");

        // --- 技能 ---
        List<Map<String, Object>> skills = List.of(
                Map.of("name", "Java / Spring Boot", "level", 92, "icon", "☕"),
                Map.of("name", "Vue.js / React", "level", 80, "icon", "⚛️"),
                Map.of("name", "MySQL / Redis", "level", 85, "icon", "🗄️"),
                Map.of("name", "Docker / K8s", "level", 72, "icon", "🐳"),
                Map.of("name", "Git / CI/CD", "level", 88, "icon", "🔧"),
                Map.of("name", "HTML5 / CSS3", "level", 90, "icon", "🎨")
        );
        model.addAttribute("skills", skills);

        // --- 项目经历 ---
        List<Map<String, String>> projects = List.of(
                Map.of(
                        "name", "电商平台微服务架构",
                        "desc", "基于Spring Cloud构建的大型电商平台，包含订单、库存、用户、支付等微服务模块，" +
                                "支持高并发秒杀场景，日均处理订单10万+。",
                        "tech", "Spring Cloud · Nacos · Sentinel · RocketMQ · MySQL",
                        "link", "#"
                ),
                Map.of(
                        "name", "企业内部管理系统",
                        "desc", "全栈开发的企业级后台管理系统，包含员工管理、考勤、审批流、报表等模块，" +
                                "采用RBAC权限模型，服务2000+员工日常使用。",
                        "tech", "Spring Boot · Vue 3 · Element Plus · PostgreSQL · Docker",
                        "link", "#"
                ),
                Map.of(
                        "name", "开源博客系统",
                        "desc", "个人主导的开源项目，支持Markdown编辑、标签分类、全文搜索、评论互动等功能，" +
                                "GitHub Stars 500+，被多所高校用作教学案例。",
                        "tech", "Spring Boot · Thymeleaf · Elasticsearch · MySQL · Redis",
                        "link", "#"
                )
        );
        model.addAttribute("projects", projects);

        // --- 时间线 ---
        List<Map<String, String>> timeline = List.of(
                Map.of("year", "2025 - 至今", "title", "高级Java开发工程师", "org", "ABC科技有限公司",
                        "desc", "负责核心业务系统的架构设计与开发，带领5人团队完成多个重点项目。"),
                Map.of("year", "2024 - 2025", "title", "Java开发工程师", "org", "XYZ互联网公司",
                        "desc", "参与电商平台后端微服务开发，负责订单和支付模块的设计与实现。"),
                Map.of("year", "2023 - 2024", "title", "初级开发工程师", "org", "DEF软件公司",
                        "desc", "从事企业级Web应用开发，主要使用Java和Vue.js技术栈。"),
                Map.of("year", "2019 - 2023", "title", "计算机科学与技术 本科", "org", "某知名大学",
                        "desc", "主修计算机科学，辅修数学。在校期间获得ACM程序设计竞赛省级银奖。")
        );
        model.addAttribute("timeline", timeline);

        return "index";
    }
}
