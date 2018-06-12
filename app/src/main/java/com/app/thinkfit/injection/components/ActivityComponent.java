package com.app.thinkfit.injection.components;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import com.app.thinkfit.injection.modules.ActivityModule;
import com.app.thinkfit.ui.about_app.AboutAppFragment;
import com.app.thinkfit.ui.auth.forgot_password.ForgotPasswordActivity;
import com.app.thinkfit.ui.auth.sign_up.detail_selected.DetailSelectedActivity;
import com.app.thinkfit.ui.auth.sign_up.level.LevelActivity;
import com.app.thinkfit.ui.auth.sign_up.register_confirm.RegisterConfirmActivity;
import com.app.thinkfit.ui.auth.sign_up.register_mode.RegisterModeActivity;
import com.app.thinkfit.ui.auth.sign_up.register_option.RegisterOptionActivity;
import com.app.thinkfit.ui.auth.sign_up.register_password.RegisterPasswordActivity;
import com.app.thinkfit.ui.auth.sign_in.SignInActivity;
import com.app.thinkfit.ui.auth.sign_up.SignUpActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_climbing_stairs.SurveyClimbingStairsActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_other.SurveyOtherActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_strengthen.SurveyStrengthenActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_workstation.SurveyWorkStationActivity;
import com.app.thinkfit.ui.contact_us.ContactUsFragment;
import com.app.thinkfit.ui.main.MainActivity;
import com.app.thinkfit.ui.my_task.MyTaskFragment;
import com.app.thinkfit.ui.my_task.add_task.AddTaskActivity;
import com.app.thinkfit.ui.my_task.complete_recovery_time.CompleteRecoveryTimeActivity;
import com.app.thinkfit.ui.my_task.complete_task.CompleteTaskActivity;
import com.app.thinkfit.ui.my_task.doing_task.DoingTaskActivity;
import com.app.thinkfit.ui.my_task.provide_improve.ProvideImproveActivity;
import com.app.thinkfit.ui.my_task.recovery_time.RecoveryTimeActivity;
import com.app.thinkfit.ui.my_task.select_reason.SelectReasonActivity;
import com.app.thinkfit.ui.my_task.stop_recovery_time.StopRecoveryTimeActivity;
import com.app.thinkfit.ui.my_task.time_over.TimeOverActivity;
import com.app.thinkfit.ui.my_task.total_point.TotalPointActivity;
import com.app.thinkfit.ui.my_task.upgrade_fitness_level.UpgradeFitnessLevelActivity;
import com.app.thinkfit.ui.notification.NotificationFragment;
import com.app.thinkfit.ui.sort_by.SortByFragment;
import com.app.thinkfit.ui.splash.SplashActivity;
import com.app.thinkfit.ui.term_and_condition.TermAndConditionFragment;
import com.app.thinkfit.ui.tutorial.TutorialActivity;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity loginActivity);

    void inject(TutorialActivity tutorialActivity);

    void inject(SignInActivity signInActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(MainActivity mainActivity);

    void inject(RegisterPasswordActivity registerPasswordActivity);

    void inject(RegisterOptionActivity registerOptionActivity);

    void inject(RegisterConfirmActivity registerConfirmActivity);

    void inject(RegisterModeActivity registerModeActivity);

    void inject(DetailSelectedActivity detailSelectedActivity);

    void inject(SurveyStrengthenActivity surveyStrengthenActivity);

    void inject(SurveyClimbingStairsActivity surveyClimbingStairsActivity);

    void inject(SurveyOtherActivity surveyOtherActivity);

    void inject(ForgotPasswordActivity forgotPasswordActivity);

    void inject(SurveyWorkStationActivity surveyWorkStationActivity);

    void inject(LevelActivity levelActivity);

    void inject(AddTaskActivity addTaskActivity);

    void inject(DoingTaskActivity doingTaskActivity);

    void inject(SelectReasonActivity selectReasonActivity);

    void inject(CompleteTaskActivity completeTaskActivity);

    void inject(RecoveryTimeActivity recoveryTimeActivity);

    void inject(StopRecoveryTimeActivity stopRecoveryTimeActivity);

    void inject(TimeOverActivity timeOverActivity);

    void inject(CompleteRecoveryTimeActivity completeRecoveryTimeActivity);

    void inject(UpgradeFitnessLevelActivity upgradeFitnessLevelActivity);

    void inject(ProvideImproveActivity provideImproveActivity);

    void inject(TotalPointActivity totalPointActivity);

    /*inject fragment*/
    void inject(SortByFragment sortByFragment);

    void inject(MyTaskFragment myTaskFragment);

    void inject(AboutAppFragment aboutAppFragment);

    void inject(NotificationFragment notificationFragment);

    void inject(ContactUsFragment contactUsFragment);

    void inject(TermAndConditionFragment termAndConditionFragment);
}
